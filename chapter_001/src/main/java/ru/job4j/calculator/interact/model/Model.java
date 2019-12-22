package ru.job4j.calculator.interact.model;

import ru.job4j.calculator.interact.assembly.CalculatorExt;
import ru.job4j.calculator.interact.controller.IData;
import ru.job4j.calculator.interact.view.View;

public class Model {
    private int currentNumber = 0;
    private String secondNumber = "";
    private String firstNumber = "0";
    private IData data;
    private View view;

    public Model(IData data, View view) {
        this.data = data;
        this.view = view;
    }

    public int process() {
        String secondNumber;
        String action;
        boolean isExit = false;
        while (!isExit) {
            String ins = data.insertFirst();
            if (ins.equals("выход")) {
                firstNumber = "выход";
                break;
            } else if (data.isDigit(ins)) {
                firstNumber = ins;
                currentNumber = Integer.parseInt(ins);
                action = data.insertSign();
            } else {
                action = ins;
            }
            firstNumber = assistSecondAndExit(firstNumber, action);
        }
        view.showScoreboard(currentNumber);
        return currentNumber;
    }

    public String  assistSecondAndExit(String firstNumber2, String action) {
        secondNumber = data.insertSecondNumber();

        if (!firstNumber2.equals("выход")) {
            currentNumber = calculate(parseNumber(firstNumber2), action, parseNumber(secondNumber));
            firstNumber = String.valueOf(currentNumber);
        }

        return firstNumber;
    }
    public int calculate(int firstNumber, String action, int secondNumber) {
        int res = 0;
        boolean ifExit = false;

        if (action.equals("+")) {
            res = CalculatorExt.add(firstNumber, secondNumber);
        } else {
            if (action.equals("-")) {
                res = CalculatorExt.subtract(firstNumber, secondNumber);
            } else {
                if (action.equals("*")) {
                    res = CalculatorExt.multiply(firstNumber, secondNumber);
                } else {
                    if (action.equals("/")) {
                        while (!ifExit) {
                            if (secondNumber == 0) {
                                view.print("деление на ноль невозможно, повторите выбор числа(делитель)");
                                String ins = data.insertString();
                                if (data.isDigit(ins)) {
                                    int a = parseNumber(ins);
                                    secondNumber = a;
                                    if (a == 0) {
                                        continue;
                                    }
                                }
                            }
                            res = CalculatorExt.div(firstNumber, secondNumber);
                            ifExit = true;
                        }
                    } else {
                        res = assistIdentificAction(String.valueOf(firstNumber), action);
                    }

                }
            }
        }

        currentNumber = res;
        view.showScoreboard(currentNumber);
        return res;
    }

    public int assistIdentificAction(String firstNumber, String action) {
        return 0;
    }

    public int parseNumber(String str) {
        return Integer.parseInt(str);
    }

}
