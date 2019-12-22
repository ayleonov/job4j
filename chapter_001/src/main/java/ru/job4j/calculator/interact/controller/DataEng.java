package ru.job4j.calculator.interact.controller;

import ru.job4j.calculator.interact.view.View;

import java.util.Scanner;

public class DataEng extends Data {

    private View view;

    public DataEng(Scanner scanner, View view) {
        super(scanner, view);
        this.view = view;
    }


    public String insertFirst() {
        String res;
        assistViewMenu();
        res = insertString();
        return res;
    }

    public void assistViewMenu() {
        view.print("Введите первое число или приняв за него текущее, выберите действие:");
        view.showMenu();
    }

    public boolean validSign(String ins) {
        boolean res = false;
        if (ins.equals("+") || ins.equals("-") || ins.equals("*")
                || ins.equals("/") || ins.equals("sin") || ins.equals("cos")
                || ins.equals("sq") || ins.equals("cb")) {
            res = true;
        }
        return res;
    }

}
