package ru.job4j.calculator.interact.assembly;

public class CalculatorEng extends CalculatorExt {

    public static int add(int first, int second) {
        int result = first + second;
        System.out.println(first + " + " + second + " = " + result);
        return result;
    }

    public static double div2(int first, int second) {
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);
        return result;
    }

    public static int multiply(int first, int second) {
        int result = first * second;
        System.out.println(first + " * " + second + " = " + result);
        return result;
    }

    public static int subtract(int first, int second) {
        int result = first - second;
        System.out.println(first + " - " + second + " = " + result);
        return result;
    }


    public static int sin(String firstNumber) {

        return (int) Math.sin(Math.toRadians(parse(firstNumber)));
    }

    public static int cos(String firstNumber) {
        return (int) Math.cos(Math.toRadians(parse(firstNumber)));
    }

    public static int sqrt(String firstNumber) {

        return (int) Math.sqrt(parse(firstNumber));
    }

    public static int cbrt(String firstNumber) {
        return (int) Math.cbrt(parse(firstNumber));
    }

    public static int parse(String str) {
        return Integer.parseInt(str);


    }
}
