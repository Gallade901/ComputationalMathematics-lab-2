package org.example.SolvingSystemOfNonlinearEquations;


import org.example.SolvingNonlinearEquation.methods.HalfMethod;
import org.example.SolvingSystemOfNonlinearEquations.functions.*;
import org.example.SolvingSystemOfNonlinearEquations.methods.Method;
import org.example.SolvingSystemOfNonlinearEquations.methods.NewtonsMethod;
import org.example.SolvingSystemOfNonlinearEquations.methods.Result;
import org.example.SolvingSystemOfNonlinearEquations.systems.SystemOfNonlinearEquations;

public class Main2 {

    private static final SystemOfNonlinearEquations[] systems = new SystemOfNonlinearEquations[] {
            new SystemOfNonlinearEquations(
                    new Function[]{
                            new Function1(),
                            new Function2()
                    }
            ),
            new SystemOfNonlinearEquations(
                    new Function[]{
                            new Function3(),
                            new Function4()
                    }
            )
    };

    public Double x0 = 0.0;
    public Double y0 = 0.0;
    public Double accuracy = 0.01;
    public Integer quantity = 1;
    public SystemOfNonlinearEquations system = new SystemOfNonlinearEquations(
            new Function[]{
                    new Function1(),
                    new Function2()
            }
    );

    public void function_choice(Integer num) {
         system = systems[num - 1];
    }
    public String check(String x0, String y0, String accuracy, String quantity) {
        InputReader inputReader = new InputReader();
        double x0D = Double.parseDouble(x0);
        double y0D = Double.parseDouble(y0);
        this.x0 = x0D;
        this.y0 = y0D;
        double accuracyD = Double.parseDouble(accuracy);
        String accuracyD_check = inputReader.readPositiveDouble(accuracyD);
        String check_quantity = inputReader.readPositiveInt(quantity);
        if (check_quantity.equals("")) {
            this.quantity = Integer.parseInt(quantity);
            if (accuracyD_check.equals("")) {
                this.accuracy = accuracyD;
                return "";
            } else {
                return accuracyD_check + " (точность)";
            }
        } else {
            return check_quantity + " (числа после запятой)";
        }
    }

    public Result run() {
        Method method = new NewtonsMethod();
        Result result = method.compute(system, x0, y0, accuracy, quantity);
        return result;
    }
}
