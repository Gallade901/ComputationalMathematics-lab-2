package org.example.SolvingNonlinearEquation.methods;



import org.example.SolvingNonlinearEquation.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class SecantMethod implements Method {

    @Override
    public Result compute(Function function, double left, double right, double accuracy, int digitsAfterComma) {
        double f, delta, x0,x1, x2;
        x0 = left;
        x1 = (left + right) / 2;
        x2 = x1 - ((x1 - x0) / (function.compute(x1) - function.compute(x0))) * function.compute(x1);
        List<String> headers = List.of("№ итерации","x_k-1", "x_k", "x_k+1", "f(x_k+1)", "|(x_k+1)-(x_k)|");
        List<List<String>> data = new ArrayList<>();

        List<String> row;
        int counter = 0;
        while (true) {
            row = new ArrayList<>();
            counter++;
            row.add(String.format("%d", counter));
            row.add(String.format("%." + digitsAfterComma + "f", x0));
            row.add(String.format("%." + digitsAfterComma + "f", x1));
            row.add(String.format("%." + digitsAfterComma + "f", x2));
            f = function.compute(x2);
            row.add(String.format("%." + digitsAfterComma + "f", f));
            delta = Math.abs(x2 - x1);
            row.add(String.format("%." + digitsAfterComma + "f", delta));
            data.add(row);
            x0 = x1;
            x1 = x2;
            x2 = x1 - ((x1 - x0) / (function.compute(x1) - function.compute(x0))) * function.compute(x1);
            if (Math.abs(function.compute(x1)) <= accuracy) {
                row = new ArrayList<>();
                counter++;
                row.add(String.format("%d", counter));
                row.add(String.format("%." + digitsAfterComma + "f", x0));
                row.add(String.format("%." + digitsAfterComma + "f", x1));
                row.add(String.format("%." + digitsAfterComma + "f", x2));
                f = function.compute(x2);
                row.add(String.format("%." + digitsAfterComma + "f", f));
                delta = Math.abs(x2 - x1);
                row.add(String.format("%." + digitsAfterComma + "f", delta));
                data.add(row);
                break;
            }
        }
        return new Result(headers, data);
    }

    @Override
    public String toString() {
        return "Метод Секущих";
    }
}
