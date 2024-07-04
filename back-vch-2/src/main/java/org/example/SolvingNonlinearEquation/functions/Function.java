package org.example.SolvingNonlinearEquation.functions;

public abstract class Function {

    private final Solution[] solutions;

    public Function(Solution[] solutions) {
        this.solutions = solutions;
    }

    public abstract double compute(double argument);

    public abstract double computeDerivative(double argument);

    public abstract double computeSecondDerivative(double argument);

    public double computeEquivalent(double argument, double left, double right) {
        double lambda;

        double dLeft = computeDerivative(left);
        double dRight = computeDerivative(right);

        if (Math.abs(dLeft) > Math.abs(dRight))
            lambda = -1 / Math.abs(dLeft);
        else
            lambda = -1 / Math.abs(dRight);

        return argument + lambda * compute(argument);
    }

    public boolean checkIsolationInterval(double left, double right) {
        System.out.println("1");
        if (left >= right) {
            System.out.println("Левая граница должна стоять до правой границы и не равняться ей.");
            return false;
        }

        for (Solution solution : solutions) {
            System.out.println("i");
            if (solution.isHasLeft() && solution.isHasRight()) {
                System.out.println("hh");
                if (solution.getLeft() < left && left < solution.getValue() && solution.getRight() > right && right > solution.getValue() && computeDerivative(left) * computeDerivative(right) > 0) {
                    return true;
                }

            }
            if (solution.isHasLeft() && solution.getLeft() < left && left < solution.getValue() && right > solution.getValue()) {
                return true;
            }
            if (solution.isHasRight() && solution.getRight() > right && right > solution.getValue() && left < solution.getValue()) {
                System.out.println("afdge");
                return true;
            }
            if (!solution.isHasLeft() && !solution.isHasRight() && left <= solution.getValue() && right >= solution.getValue()) {
                return true;
            }
        }
        System.out.println("end");
        return false;
    }

    public Solution[] getIsolationIntervals() {
        return solutions;
    }

}
