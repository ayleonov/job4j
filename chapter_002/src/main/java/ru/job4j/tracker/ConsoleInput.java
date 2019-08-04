package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        String res;
        System.out.println(question);
        while (true) {
            String scanText = scanner.nextLine();
            if (scanText != null) {
                res = scanText;
                break;
            } else {
                System.out.println("Incorrect! Repeat input");
            }
        }
        return res;
    }
}