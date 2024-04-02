package org.example.SolvingNonlinearEquation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {

    public String readPositiveInt(String num) {
        try {
            int value = Integer.parseInt(num);
            if (value > 0)
                return "";
            return ("Требуется ввести положительное число");
        } catch (InputMismatchException | NumberFormatException e) {
            return "Требуется ввести целое число";
        }
    }

    public double readDouble(String message) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(message);
                String buffer = scanner.next();
                if (buffer.equals("exit"))
                    System.exit(0);
                buffer = buffer.replaceAll(",", ".");
                return Double.parseDouble(buffer);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Требуется ввести число.");
            }
        }
    }

    public String readPositiveDouble(Double num) {
        if (num >= 0) {
            return "";
        }
        else {
            return "Требуется ввести положительное число";
        }
    }

    public int readIndex(String message, String notFoundMessage, int length) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(message);
                String buffer = scanner.next();
                if (buffer.equals("exit"))
                    System.exit(0);
                int value = Integer.parseInt(buffer);
                if (value <= 0) {
                    System.out.println("Требуется ввести положительное число.");
                    continue;
                }
                if (value - 1 >= length) {
                    System.out.println(notFoundMessage);
                    continue;
                }
                return value - 1;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Требуется ввести целое число.");
            }
        }
    }

    public String readFilename(String message) {
        while (true) {
            System.out.print(message);
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();
            if (filename.equals("exit"))
                System.exit(0);
            if (!filename.isBlank())
                return filename;
            System.out.println("Название файла не может быть пустым.");
        }
    }
}
