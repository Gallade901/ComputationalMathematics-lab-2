package org.example.SolvingNonlinearEquation.methods;

import org.example.SolvingNonlinearEquation.functions.Function;

public interface Method {

    Result compute(Function function, double left, double right, double accuracy, int digitsAfterComma);

}
