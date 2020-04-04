package ru.job4j.calculator.interact;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.calculator.interact.controller.Data;
import ru.job4j.calculator.interact.controller.IData;
import ru.job4j.calculator.interact.model.Model;
import ru.job4j.calculator.interact.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class InteractCalcTest {

    private Scanner scanner;
    private InteractCalc calc;
    private Scanner scanner2;
    private InteractCalc calc2;
    private IData data;
    private IData data2;
    private Model model;
    private Model model2;
    private View view;

    @Before
    public void beforeTest() throws FileNotFoundException {
        File file = new File("./data/calc_insert.txt");
        File file2 = new File("./data/calc_insert2.txt");
        view = new View();
        scanner = new Scanner(file);
        scanner2 = new Scanner(file2);
        data = new Data(scanner, view);
        data2 = new Data(scanner2, view);
        calc = new InteractCalc(scanner);
        calc2 = new InteractCalc(scanner2);
        model = new Model(data, view);
        model2 = new Model(data2, view);
    }

    @After
    public void afterTest() {
        if (scanner != null) {
            scanner.close();
        }
        if (scanner2 != null) {
            scanner2.close();
        }
    }

    @Test
    public void whenTestingInsertString() {
        String res = data.insertString();
        assertThat(res, is("677"));
    }

    @Test
    public void whenTestingInsertFirst() {
        String res = data.insertFirst();
        assertThat(res, is("677"));
        String res2 = data2.insertFirst();
        assertThat(res2, is("+"));
    }

    @Test
    public void whenTestingIsDigit() {
        boolean res = data.isDigit("word#1");
        boolean res2 = data.isDigit("325");
        assertFalse(res);
        assertTrue(res2);
    }

    @Test
    public void whenTestingInsertSecondNumber() {
        String res = data.insertSecondNumber();
        assertThat(res, is("677"));
    }


    @Test
    public void whenTestingInsertSign() {
        String res = data2.insertSign();
        assertThat(res, is("+"));
    }

    @Test
    public void whenTestingParseNumber() {
        int res = model.parseNumber("433");
        assertThat(res, is(433));
    }

    @Test
    public void whenTestingValidSign() {
        boolean res = data.validSign("/");
        assertTrue(res);
        boolean res2 = data.validSign("aaa");
        assertFalse(res2);
    }

    @Test
    public void whenTestingCalculate() {
        int first = 20;
        int second = 30;
        String action = "+";
        int res = model.calculate(first, action, second);
        assertThat(res, is(50));

        int first2 = 20;
        int second2 = 30;
        String action2 = "-";
        int res2 = model.calculate(first2, action2, second2);
        assertThat(res2, is(-10));

        int first3 = 20;
        int second3 = 30;
        String action3 = "*";
        int res3 = model.calculate(first3, action3, second3);
        assertThat(res3, is(600));

        int first4 = 200;
        int second4 = 40;
        String action4 = "/";
        int res4 = model.calculate(first4, action4, second4);
        assertThat(res4, is(5));

        /*в тесте, когда делитель = 0, то программа делает запрос другого
        числа и забирает его из файлa, т.к. класс запущен через new Scanner(file) */
        int first5 = 6770;
        int second5 = 0;
        String action5 = "/";
        int res5 = model.calculate(first5, action5, second5);
        assertThat(res5, is(10));
    }

    @Test
    public void whenTestingProcess() {

        int res = model.process();
        assertThat(res, is(700));


        int res2 = model2.process();
        assertThat(res2, is(3));
    }

    @Test
    public void whenTestingShowCurrentNumber() {
        int res = view.showScoreboard(701);
        assertThat(res, is(701));
    }

    @Test
    public void whenTestingProject() {

    }
}