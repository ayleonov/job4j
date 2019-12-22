package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

/**
 * Launch tracker.
 */
public class StartUI {

    private Input input;
    private ITracker tracker;
    private Consumer<String> output;
    private MenuTracker menu;

    /**
     *
     * @param input Input to menu.
     * @param tracker Tracker.
     * @param output  Output.
     */
    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
        this.menu = new MenuTracker(this.input, this.tracker, this.output);
    }

    /**
     * select from menu.
     */
    public void select() {

        List<Integer> ranges = menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit? y/n")));
    }

    /**
     * method starts manual work .
     * @param args
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput(new ConsoleInput());
        new StartUI(input, tracker, System.out::println).select();
    }
}
// java -cp target\chapter_002-2.0.jar ru.job4j.tracker.StartUI