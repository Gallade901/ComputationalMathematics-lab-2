package org.example.SolvingNonlinearEquation;


import org.example.SolvingNonlinearEquation.functions.Function;
import org.example.SolvingNonlinearEquation.functions.Function1;
import org.example.SolvingNonlinearEquation.functions.Function2;
import org.example.SolvingNonlinearEquation.functions.Function3;
import org.example.SolvingNonlinearEquation.methods.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class Main {

    private static final Function[] functions = {
            new Function1(),
            new Function2(),
            new Function3()
    };

    private static final Method[] methods = {
            new HalfMethod(),
            new SecantMethod(),
            new SimpleIterationMethod()
    };
    public Function function = new Function1();
    public Method method = new HalfMethod();
    public Double left = 0.0;
    public Double right = 0.0;
    public Double accuracy = 0.01;
    public Integer quantity = 1;
    public InputReader inputReader = new InputReader();

    public String function_choice(Integer functionIndex) {
        function = functions[functionIndex - 1];
        return "";
    }
    public Result method_choice(Integer methodIndex) {
        method = methods[methodIndex - 1];
        Result result = method.compute(function, left, right, accuracy, quantity);
        return result;
    }
    public String check(String leftValue, String rightValue, String accuracy, String quantity) {
        left = Double.parseDouble(leftValue);
        right = Double.parseDouble(rightValue);
        double accuracyD = Double.parseDouble(accuracy);
        if (function.checkIsolationInterval(left, right)) {
            String accuracyD_check = inputReader.readPositiveDouble(accuracyD);
            if (accuracyD_check.equals("")) {
                this.accuracy = accuracyD;
                String quantity_check = inputReader.readPositiveInt(quantity);
                if (quantity_check.equals("")) {
                    this.quantity = Integer.parseInt(quantity);
                    return "";
                } else {
                    return quantity_check + " (числа после запятой)";
                }
            } else {
                return accuracyD_check + " (точность)";
            }
        } else {
            return "Интервал изоляции корня введен некорректно.\n" +
                    "Проверьте, что:\n" +
                    "1) Функция на концах введенного интервала принимает значения разного знака\n" +
                    "2) Производная функции одного знака на всем введенном интервале";
        }
    }
//
//        double accuracy = inputReader.readPositiveDouble("Введите точность: ");
//        int digitsAfterComma = inputReader.readPositiveInt("Введите кол-во знаков после запятой: ");
//

//        TableGenerator generator = new TableGenerator();
//        String tableResult = generator.generate(result);
//        String stringBuilder = "Уравнение: " +
//                function.toString() +
//                "\n" +
//                "Метод: " +
//                method.toString() +
//                "\n" +
//                tableResult;
//        OutputWriter outputWriter = new OutputWriter();
//        outputWriter.output(stringBuilder);
//
//        System.exit(0)
}
