package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;

    }

    public static void main(String[] args) throws Exception {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }

    public void init() throws MenuOutException {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        int[] ranges = menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit? y/n")));
    }


}
// java -cp target\chapter_002-2.0.jar ru.job4j.tracker.StartUI