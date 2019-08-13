package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final Tracker tracker = new Tracker();
    private final Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
    private final Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private String showConsole(String insert) {
        String result = new StringBuilder()
                .append("0. Add new Item\r\n")
                .append("1. Show all items\r\n")
                .append("2. Edit item\r\n")
                .append("3. Delete item\r\n")
                .append("4. Find item by Id\r\n")
                .append("5. Find items by name\r\n")
                .append("6. Exit Program\r\n")
                .append(insert)
                .append("0. Add new Item\r\n")
                .append("1. Show all items\r\n")
                .append("2. Edit item\r\n")
                .append("3. Delete item\r\n")
                .append("4. Find item by Id\r\n")
                .append("5. Find items by name\r\n")
                .append("6. Exit Program\r\n")
                .append("\n")
                .append("Выходим из программы!\n")
                .append("\r\n")
                .toString();
        return result;
    }

    private void testing(String insert) {
        assertThat(out.toString(), is(
                new StringBuilder(showConsole(insert)).toString()));
    }

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasItemWithTheSameName() throws Exception {

        Input input = new StubInput(new String[]{"0", "три", "третья заявка", "y"});
        new StartUI(input).init();

        //menu.
        Item[] items = {first, second, new Item("три", "третья заявка", System.currentTimeMillis())};
        Item[] result = tracker.findAll();
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getName(), is(items[i].getName()));
            assertThat(result[i].getDesc(), is(items[i].getDesc()));
        }
    }

    @Test
    public void whenUserAddItemThenTrackerInListHasItemWithTheSameNameAndDescription() throws Exception {

        Input input = new StubInput(new String[]{"0", "один", "первая заявка", "y"});
        new StartUI(input).init();
        assertThat(tracker.findAll()[0].getName(), is("один"));
        assertThat(tracker.findAll()[0].getDesc(), is("первая заявка"));
    }

    @Test
    public void whenSelectAllThenTrackerShowItemFirstSecond() throws Exception {
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input).init();
        Item[] result = {first, second};
        assertThat(tracker.findAll(), is(result));
    }


    @Test
    public void whenEditThenTrackerHasUpdatedValue() throws Exception {
        Input input = new StubInput(new String[]{"2", first.getId(), "тест замены", "заменили заявку", "y"});
        new StartUI(input).init();

        Item[] items = {first, second};
        items[0].setName("тест замены");
        items[0].setDesc("заменили заявку");
        Item[] result = tracker.findAll();
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getName(), is(items[i].getName()));
            assertThat(result[i].getName(), is(items[i].getName()));
        }
    }

    @Test
    public void whenDeleteThenFirstItemChangeToSecond() throws Exception {

        Input input = new StubInput(new String[]{"3", first.getId(), "y"});
        new StartUI(input).init();
        assertThat(tracker.findAll()[0].getName(), is("два"));
    }

    @Test
    public void whenDeleteThenFirstItemChangeToSecond2() throws Exception {

        Input input = new StubInput(new String[]{"3", first.getId(), "y"});
        new StartUI(input).init();
        assertThat(tracker.findAll(), is(new Item[]{second}));
    }

    @Test
    public void whenSelectByIdItemHasIdThenEqualWithName() throws Exception {

        Input input = new StubInput(new String[]{"4", first.getId(), "y"});
        new StartUI(input).init();
        assertThat(tracker.findAll(), is(new Item[]{first, second}));
    }

    @Test
    public void whenSelectByNamesOf3ItemsThenFound2Matches() throws Exception {
        Item third = tracker.add(new Item("один", "третья заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", first.getName(), "y"});
        new StartUI(input).init();
        Item itemFirst = (tracker.findByName(first.getName()))[0];
        Item itemSecond = (tracker.findByName(first.getName()))[1];
        assertThat(itemFirst.getName(), is("один"));
        assertThat(itemFirst.getDesc(), is("первая заявка"));
        assertThat(itemSecond.getName(), is("один"));
        assertThat(itemSecond.getDesc(), is("третья заявка"));
    }

    @Test
    public void whenAddThenPrinting() throws Exception {

        Input input = new StubInput(new String[]{"0", "три", "третья заявка", "y"});
        new StartUI(input).init();


        String insert = new StringBuilder("------------ Добавление новой заявки --------------\r\n")

                .append("------------ Новая заявка с getId : 1565817231397-----------\r\n")
                .toString();
        //testing(insert);
    }

    @Test
    public void whenSelectAllThenPrinting() throws Exception {

        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input).init();

        String insert = new StringBuilder(
                "\n------------ Вывод списка заявок --------------\r\n")
                .append("имя заявки:  описание заявки: \r\n")
                .append("- - - - - - - - - - - - - - - - \r\n")
                .append("один  первая заявка\r\n")
                .append("два  вторая заявка\r\n")
                .append("--------------------------------------------\r\n")
                .toString();

        testing(insert);
    }

    @Test
    public void whenEditThenPrinting() throws Exception {

        Input input = new StubInput(new String[]{"2", first.getId(), "тест замены", "заменили заявку", "y"});
        new StartUI(input).init();

        String insert = new StringBuilder("------------ Исправление заявки --------------\r\n")
                .append("\n------------ Исправленная заявка: ------------\r\n")
                .append("тест замены заменили заявку\r\n")
                .append("----------------------------------------------\r\n")
                .toString();

        testing(insert);
    }


    @Test
    public void whenDeleteExistingItemThenPrinting() throws Exception {

        Input input = new StubInput(new String[]{"3", first.getId(), "y"});
        new StartUI(input).init();


        String insert = new StringBuilder("------------ Удаление заявки --------------\r\n")
                .append("\n------------ Заявка удалена --------------\r\n")
                .toString();

        testing(insert);
    }

    @Test
    public void whenTryDeleteNonExistingItemThenPrinting() throws Exception {

        Input input = new StubInput(new String[]{"3", "222", "y"});
        new StartUI(input).init();


        String insert = new StringBuilder("------------ Удаление заявки --------------\r\n")
                .append("заявка не найдена.\n\r\n")
                .toString();

        testing(insert);
    }

    @Test
    public void whenSelectExistingItemByIdThenPrinting() throws Exception {

        Input input = new StubInput(new String[]{"4", first.getId(), "y"});
        new StartUI(input).init();

        String insert = new StringBuilder("------------ Поиск заявки по идентификатору --------------\r\n")
                .append("------------ Найдена заявка: " + first.getName() + " " + first.getDesc() + "--------------\r\n")
                .toString();

        testing(insert);
    }

    @Test
    public void whenTrySelectNonExistingItemByIdThenPrinting() throws Exception {

        Input input = new StubInput(new String[]{"4", "222", "y"});
        new StartUI(input).init();

        String insert = new StringBuilder("------------ Поиск заявки по идентификатору --------------\r\n")
                .append("заявка не найдена.\n\r\n")
                .toString();
        testing(insert);
    }

    @Test
    public void whenSelectByExistingNameThenPrinting() throws Exception {
        Item third = tracker.add(new Item("один", "третья заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", first.getName(), "y"});
        new StartUI(input).init();

        String insert = new StringBuilder("------------ Поиск заявки по слову --------------\r\n")
                .append("\n------------ Найдены заявки:  имя описание --------------\r\n")
                .append("" + first.getName() + " " + first.getDesc() + "\r\n")
                .append("" + first.getName() + " " + third.getDesc() + "\r\n")
                .append("---------------------------------------------------------\n\r\n")

                .toString();
        testing(insert);
    }

    @Test
    public void whenTrySelectByNonExistingNameThenPrinting() throws Exception {
        Item third = tracker.add(new Item("один", "третья заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", "222", "y"});
        new StartUI(input).init();

        String insert = new StringBuilder("------------ Поиск заявки по слову --------------\r\n")

                .append("заявка не найдена.\n\r")
                .append("\n---------------------------------------------------------\n\r\n")

                .toString();
        testing(insert);
    }
}