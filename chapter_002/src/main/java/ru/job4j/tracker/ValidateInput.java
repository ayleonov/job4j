package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {

    private Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }


    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }


    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid date: ");
            }   catch (MenuOutException mof) {
                System.out.println("Please select key from menu:");
            }
        } while (invalid);
        return value;
    }
}
