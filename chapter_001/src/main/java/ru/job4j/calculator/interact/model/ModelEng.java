package ru.job4j.calculator.interact.model;

import ru.job4j.calculator.interact.assembly.CalculatorEng;
import ru.job4j.calculator.interact.assembly.CalculatorExt;
import ru.job4j.calculator.interact.controller.IData;
import ru.job4j.calculator.interact.view.View;

import java.util.List;

public class ModelEng extends Model {
    private int currentNumber = 0;
    private String firstNumber = "0";
    String secondNumber;
    private IData data;
    private View view;

    public ModelEng(IData data, View view) {
        super(data, view);
        this.data = data;
        this.view = view;
    }
    @Override
    public String assistSecondAndExit(String firstNumber2, String action) {

        List<String> adds = List.of("sin", "cos", "sq", "cb");
        if (!adds.contains(action)) {
            secondNumber = data.insertSecondNumber();
        } else {
            secondNumber = "0";
        }
        if (!firstNumber2.equals("выход")) {
            currentNumber = calculate(parseNumber(firstNumber2), action, parseNumber(secondNumber));
            firstNumber = String.valueOf(currentNumber);
        }
        return firstNumber;
    }

    @Override
    public int assistIdentificAction(String firstNumber, String action) {
        int res = 0;

        if (action.equals("sin")) {
            res = CalculatorEng.sin(firstNumber);
        } else if (action.equals("cos")) {
            res = CalculatorEng.cos(firstNumber);
        } else if (action.equals("sq")) {
            res = CalculatorEng.sqrt(firstNumber);
        } else if (action.equals("cb")) {
            res = CalculatorEng.cbrt(firstNumber);
        }

        return res;
    }

}



