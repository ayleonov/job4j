package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    private Input input;
    private Tracker tracker;
    private Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;

    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput(new ConsoleInput());
        new StartUI(input, tracker, System.out::println).init();
    }

    public void init() throws MenuOutException {
        MenuTracker menu = new MenuTracker(this.input, tracker, output);
        List<Integer> ranges = menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit? y/n")));
    }


}
// java -cp target\chapter_002-2.0.jar ru.job4j.tracker.StartUI