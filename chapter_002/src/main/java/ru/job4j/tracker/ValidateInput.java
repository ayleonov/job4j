package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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