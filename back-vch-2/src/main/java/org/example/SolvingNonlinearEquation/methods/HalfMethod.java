package org.example.SolvingNonlinearEquation.methods;


import org.example.SolvingNonlinearEquation.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class HalfMethod implements Method {

    @Override
    public Result compute(Function function, double left, double right, double accuracy, int digitsAfterComma) {
        double a, b, x, fa, fb, fx;
        a = left;
        b = right;


        List<String> headers = List.of("№ шага", "a", "b", "x", "f(a)", "f(b)", "f(x)", "|a-b|");
        List<List<String>> data = new ArrayList<>();

        List<String> row;
        int counter = 0;
        while (true) {
            row = new ArrayList<>();
            counter++;
            fa = function.compute(a);
            fb = function.compute(b);
            x = (a + b) / 2;
            fx = function.compute(x);

            row.add(String.format("%d", counter));
            row.add(String.format("%." + digitsAfterComma + "f", a));
            row.add(String.format("%." + digitsAfterComma + "f", b));
            row.add(String.format("%." + digitsAfterComma + "f", x));
            row.add(String.format("%." + digitsAfterComma + "f", fa));
            row.add(String.format("%." + digitsAfterComma + "f", fb));
            row.add(String.format("%." + digitsAfterComma + "f", fx));
            row.add(String.format("%." + digitsAfterComma + "f", Math.abs(a - b)));
            data.add(row);

            if (Math.abs(a-b) <= accuracy)
                break;
            if (fx > 0)
                b = x;
            else
                a = x;
        }

        return new Result(headers, data);
    }


    @Override
    public String toString() {
        return "Метод половинного деления";
    }
}
