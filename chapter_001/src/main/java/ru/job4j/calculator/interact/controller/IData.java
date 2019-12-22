package ru.job4j.calculator.interact.controller;

public interface IData {

    String insertFirst();

    String insertSecondNumber();

    String insertString();

    String insertSign();

    boolean isDigit(String ins);

    boolean validSign(String ins);

}
