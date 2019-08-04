package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        String res = null;
        System.out.println(question);
        String scanText = scanner.nextLine();
        if (scanText != null && scanText !="")
            res = scanText;
        return res;
    }
}