package org.example.SolvingSystemOfNonlinearEquations.methods;


import org.example.SolvingSystemOfNonlinearEquations.systems.SystemOfNonlinearEquations;

public interface Method {

    Result compute(SystemOfNonlinearEquations system, double x0, double y0, double accuracy, int digitsAfterComma);

}
