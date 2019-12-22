package ru.job4j.calculator.interact.controller;

import ru.job4j.calculator.interact.view.View;

import java.util.Scanner;

public class Data implements IData{
    private Scanner scanner;
    private View view;

    public Data(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public String insertFirst() {
        String res;
        assistViewMenu();
        res = insertString();
        return res;
    }

    public void assistViewMenu(){
        view.print("Введите первое число или приняв за него текущее, выберите действие:");
        view.showMenu();
    }

    public String insertSecondNumber() {
        String res = "";
        boolean ifExit = false;
        //System.out.println("Введите второе число: ");
        view.print("Введите второе число: ");
        while (!ifExit) {
            String ins = insertString();
            if (isDigit(ins)) {
                res = ins;
                ifExit = true;
            } else {
                view.print("Некорректный ввод. Повторите ввод числа!");
            }
        }
        return res;
    }

    public String insertString() {
        //System.out.println(scanner.hasNext());
        String res = scanner.next();
        //System.out.println(res);
        return res;
    }

    public String insertSign() {
        String res = "";
        view.print("Введите знак действия:");
        boolean isExit = false;
        while (!isExit) {
            String ins = scanner.next();
            if (validSign(ins)) {
                res = ins;
                isExit = true;
            } else {
                view.print("некорректный ввод! Введите знак действия заново");
            }
        }
        return res;
    }

    public boolean isDigit(String ins) {
        boolean res = false;
        if (ins.matches("-?\\d+")) {
            res = true;
        }
        return res;
    }

    public boolean validSign(String ins) {
        boolean res = false;
        if (ins.equals("+") || ins.equals("-") || ins.equals("*")
                || ins.equals("/")) {
            res = true;
        }
        return res;
    }


}
