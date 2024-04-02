package org.example.SolvingSystemOfNonlinearEquations.methods;

public class Kramer {

    public double[] compute(double[] firstEquation, double[] secondEquation) {
        double d = firstEquation[0] * secondEquation[1] - firstEquation[1] * secondEquation[0];
        double dx = firstEquation[2] * secondEquation[1] - firstEquation[1] * secondEquation[2];
        double dy = firstEquation[0] * secondEquation[2] - firstEquation[2] * secondEquation[0];
        //d = f1'x * f2'y - f1'y * f2'x
        //dx = -f1 * f2'y - f1'y * -f2
        return new double[]{dx / d, dy / d};
    }

}
