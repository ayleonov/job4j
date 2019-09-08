package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {
    private final static int NUMBER_POINTS_MENU = 7;
    private Input input;
    private Consumer<String> output;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>(NUMBER_POINTS_MENU);

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public List<Integer> fillActions() {
        List<Integer> menunumbers = new ArrayList<>(NUMBER_POINTS_MENU);
        actions.add(this.new AddItem(0, "Add new item"));
        actions.add(this.new ShowItems(1, "Show all items"));
        actions.add(this.new EditItem(2, "Edit item"));
        actions.add(this.new DeleteItems(3, "Delete item"));
        actions.add(this.new FindById(4, "Find item by id"));
        actions.add(this.new FindByName(5, "Find items by name"));
        actions.add(this.new ExitProgram(6, "Exit program"));

        for (int i = 0; i < actions.size(); i++) {
            menunumbers.add(actions.get(i).key());
        }

        return menunumbers;
    }

    public void select(int key) {
        actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            long time = System.currentTimeMillis();
            tracker.add(new Item(name, desc, time));
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("---------------Items found (name description id): --------------");
            for (Item item : tracker.findAll()) {
                output.accept(String.format("%s %s %s", item.getName(), item.getDesc(), item.getId()));
            }
            output.accept("--------------------------------------------");
        }
    }

    private class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            long time = System.currentTimeMillis();
            Item item = new Item(name, desc, time);
            tracker.replace(id, item);
            output.accept("------------ Edit of item --------------");
            output.accept("------------ Edited item: --------------");
            output.accept(String.format("%s %s", name, desc));
            output.accept("------------ Item replaced --------------");
        }
    }

    private class DeleteItems extends BaseAction {
        public DeleteItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            output.accept("-------------- Delete item --------------");
            boolean result = tracker.delete(id);
            if (result) {
                output.accept("\n---------- Item deleted -------------");
            } else {
                output.accept("Item not founded.");
            }
            output.accept("-----------------------------------------");
        }
    }

    private class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Id search --------------");
            String id = input.ask("Please, enter the task's id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                output.accept(String.format("------------ Item found: %s %s --------------", item.getName(), item.getDesc()));
            } else {
                output.accept("Item NOT found.\n");
            }
        }
    }

    private class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Search item by name --------------");
            String word = input.ask("Enter name for find the item :");
            List<Item> foundItems = tracker.findByName(word);
            if (foundItems.size() != 0) {
                output.accept("------------ Items found:  name description id --------------");
                for (Item item : foundItems) {
                    output.accept(String.format("%s %s %s", item.getName(), item.getDesc(), item.getId()));
                }
            } else {
                output.accept("Item NOT found.");
            }
            output.accept("---------------------------------------------------------");
        }
    }

    private class ExitProgram extends BaseAction {
        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

            output.accept("Exit the program");
        }

    }


    //  cd c:\\projects\job4j\chapter_002
    // java -cp target/tracker.jar ru.job4j.tracker.StartUI
}