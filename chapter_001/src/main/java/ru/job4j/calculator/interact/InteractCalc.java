package ru.job4j.calculator.interact;


import ru.job4j.calculator.interact.controller.Data;
import ru.job4j.calculator.interact.controller.IData;
import ru.job4j.calculator.interact.model.Model;
import ru.job4j.calculator.interact.view.View;

import java.util.Scanner;

public class InteractCalc {
        private Scanner scan = new Scanner(System.in);

    public InteractCalc(Scanner scanner) {
        this.scan = scanner;
    }

    public InteractCalc() {
    }

    public static void main(String[] args) {
        InteractCalc calc = new InteractCalc();
        View view = new View();
        IData data = new Data(calc.scan, view);
        Model model = new Model(data, view);
        model.process();
        calc.scan.close();
    }

}



