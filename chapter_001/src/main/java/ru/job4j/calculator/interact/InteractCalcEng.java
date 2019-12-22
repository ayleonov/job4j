package ru.job4j.calculator.interact;


import ru.job4j.calculator.interact.controller.DataEng;
import ru.job4j.calculator.interact.controller.IData;
import ru.job4j.calculator.interact.model.Model;
import ru.job4j.calculator.interact.model.ModelEng;
import ru.job4j.calculator.interact.view.View;
import ru.job4j.calculator.interact.view.ViewEng;

import java.util.Scanner;

public class InteractCalcEng extends InteractCalc{
        private Scanner scan = new Scanner(System.in);

    public InteractCalcEng(Scanner scanner) {
        this.scan = scanner;
    }

    public InteractCalcEng() {
    }

    public static void main(String[] args) {
        InteractCalcEng calc = new InteractCalcEng();
        View view = new ViewEng();
        IData data = new DataEng(calc.scan, view);
        Model model = new ModelEng(data, view);
        model.process();
        calc.scan.close();
    }

}



