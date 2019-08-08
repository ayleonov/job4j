package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DEL = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private Scanner scanner = new Scanner(System.in);
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) throws Exception {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    public void init() throws Exception {

        boolean ifExit = false;
        while (!ifExit) {
            if (start()) {
                break;
            }
        }
    }

    public boolean start() throws Exception {
        boolean ifExit = false;

        int selection = select();
        if (selection == 6) {
            System.out.println("\nВыходим из программы!\n");
            ifExit = true;
        } else {
            menurealize(selection);
        }
        return ifExit;
    }

    public int select() throws Exception {
        int res = -1;
        showMenu();
        String answerStr = this.input.ask("Select:");
        if (answerStr != null) {
            res = Integer.parseInt(answerStr);
        }
        return res;
    }

    public void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public void menurealize(int selection) {
        switch (selection) {
            case 0:
                this.createItem();
                break;
            case 1:
                this.selectAllItems();
                break;
            case 2:
                this.editItems();
                break;
            case 3:
                this.delete();
                break;
            case 4:
                this.selectById();
                break;
            case 5:
                this.selectByName();
                break;
            default:
        }
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void selectAllItems() {
        System.out.println("\n------------ Вывод списка заявок --------------");
        System.out.println("имя заявки:  описание заявки: ");
        System.out.println("- - - - - - - - - - - - - - - - ");
        Item[] allItems = tracker.findAll();
        if (allItems.length == 0) {
            System.out.println("заявок нет");
        } else {
            for (Item item : allItems) {
                System.out.println(item.getName() + "  " + item.getDesc());
            }
        }
        System.out.println("--------------------------------------------");
    }

    private void editItems() {
        System.out.println("------------ Исправление заявки --------------");
        String id;
        id = this.input.ask("Введите id для поиска заявки :");

        if (tracker.findById(id) != null) {
            String name = this.input.ask("Введите имя заявки :");
            String desc = this.input.ask("Введите описание заявки :");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.replace(id, item);
            System.out.println("\n------------ Исправленная заявка: ------------");
            System.out.println(item.getName() + " " + item.getDesc());
            System.out.println("----------------------------------------------");
        } else {
            System.out.println("заявка не найдена\n");
        }
    }

    private void delete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id для поиска заявки :");
        boolean result = tracker.delete(id);
        if (result) {
            System.out.println("\n------------ Заявка удалена --------------");
        } else {
            System.out.println("заявка не найдена.\n");
        }
    }

    private void selectById() {
        System.out.println("------------ Поиск заявки по идентификатору --------------");
        String id = this.input.ask("Введите id для поиска заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("------------ Найдена заявка: " + item.getName() + " " + item.getDesc() + "--------------");
        } else {
            System.out.println("заявка не найдена.\n");
        }
    }

    private void selectByName() {
        System.out.println("------------ Поиск заявки по слову --------------");
        String key = this.input.ask("Введите слово для поиска заявки :");
        Item[] foundItems = tracker.findByName(key);
        if (foundItems.length != 0) {
            System.out.println("\n------------ Найдены заявки:  имя описание --------------");
            for (Item item : foundItems) {
                System.out.println(item.getName() + " " + item.getDesc());
            }
        } else {
            System.out.println("заявка не найдена.\n");
        }
        System.out.println("---------------------------------------------------------\n");
    }
}
// java -cp target\chapter_002-2.0.jar ru.job4j.tracker.StartUI