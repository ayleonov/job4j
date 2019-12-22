package ru.job4j.calculator.interact.assembly;

public class CalculatorExt implements IAssembly {

    public static int add(int first, int second) {
        int result = first + second;
        System.out.println(first + " + " + second + " = " + result);
        return result;
    }

    public static int div(int first, int second) {
        int result = first / second;
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

    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtract(10, 5);
    }
}