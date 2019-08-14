package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private String showConsole(String insert) {
        String result = new StringBuilder()
                .append("0. Add new item\r\n")
                .append("1. Show all items\r\n")
                .append("2. Edit item\r\n")
                .append("3. Delete item\r\n")
                .append("4. Find item by id\r\n")
                .append("5. Find items by name\r\n")
                .append("6. Exit program\r\n")
                .append(insert)
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
    public void whenUserAddItemThenTrackerHasItemWithTheSameName() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"0", "три", "третья заявка", "y"});
        new StartUI(input, tracker).init();

        //menu.
        Item[] items = {first, second, new Item("три", "третья заявка", System.currentTimeMillis())};
        Item[] result = tracker.findAll();
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i].getName(), is(items[i].getName()));
            assertThat(result[i].getDesc(), is(items[i].getDesc()));
        }
    }

    @Test
    public void whenUserAddItemThenTrackerInListHasItemWithTheSameNameAndDescription() {
        Tracker tracker = new Tracker();

        Input input = new StubInput(new String[]{"0", "один", "первая заявка", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("один"));
        assertThat(tracker.findAll()[0].getDesc(), is("первая заявка"));
    }

    @Test
    public void whenSelectAllThenTrackerShowItemFirstSecond() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        Item[] result = {first, second};
        assertThat(tracker.findAll(), is(result));
    }


    @Test
    public void whenEditThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", first.getId(), "тест замены", "заменили заявку", "y"});
        new StartUI(input, tracker).init();

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
    public void whenDeleteThenFirstItemChangeToSecond() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", first.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("два"));
    }

    @Test
    public void whenDeleteThenFirstItemChangeToSecond2() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", first.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Item[]{second}));
    }

    @Test
    public void whenSelectByIdItemHasIdThenEqualWithName() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", first.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Item[]{first, second}));
    }

    @Test
    public void whenSelectByNamesOf3ItemsThenFound2Matches() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Item third = tracker.add(new Item("один", "третья заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", first.getName(), "y"});
        new StartUI(input, tracker).init();
        Item itemFirst = (tracker.findByName(first.getName()))[0];
        Item itemSecond = (tracker.findByName(first.getName()))[1];
        assertThat(itemFirst.getName(), is("один"));
        assertThat(itemFirst.getDesc(), is("первая заявка"));
        assertThat(itemSecond.getName(), is("один"));
        assertThat(itemSecond.getDesc(), is("третья заявка"));
    }

    @Test
    public void whenAddThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"0", "три", "третья заявка", "y"});
        new StartUI(input, tracker).init();


        String insert = new StringBuilder("------------ Добавление новой заявки --------------\r\n")

                .append("------------ Новая заявка с getId : 1565817231397-----------\r\n")
                .toString();
        //testing(insert);
    }

    @Test
    public void whenSelectAllThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();

        String insert = new StringBuilder(
                "---------------Items found (name description id): --------------\r\n")


                .append("один первая заявка " + first.getId() + "\r\n")
                .append("два вторая заявка " + second.getId() + "\r\n")

                .append("--------------------------------------------\r\n")
                .toString();

        testing(insert);
    }

    @Test
    public void whenEditThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", first.getId(), "тест замены", "заменили заявку", "y"});
        new StartUI(input, tracker).init();

        String insert = new StringBuilder("------------ Edit of item --------------\r\n")
                .append("------------ Edited item: --------------\r\n")
                .append("тест замены заменили заявку\r\n")
                .append("------------ Item replaced --------------\r\n")
                .toString();

        testing(insert);
    }


    @Test
    public void whenDeleteExistingItemThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", first.getId(), "y"});
        new StartUI(input, tracker).init();


        String insert = new StringBuilder("-------------- Delete item --------------\r\n")
                .append("\n---------- Item deleted -------------\r\n")
                .append("-----------------------------------------\r\n")
                .toString();

        testing(insert);
    }

    @Test
    public void whenTryDeleteNonExistingItemThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", "222", "y"});
        new StartUI(input, tracker).init();


        String insert = new StringBuilder("-------------- Delete item --------------\r\n")
                .append("Item not founded.\r\n")
                .append("-----------------------------------------\r\n")
                .toString();

        testing(insert);
    }

    @Test
    public void whenSelectExistingItemByIdThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", first.getId(), "y"});
        new StartUI(input, tracker).init();

        String insert = new StringBuilder("------------ Id search --------------\r\n")
                .append(String.format("------------ Item found: %s %s --------------\r\n", first.getName(), first.getDesc()))
                .toString();

        testing(insert);
    }

    @Test
    public void whenTrySelectNonExistingItemByIdThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", "222", "y"});
        new StartUI(input, tracker).init();

        String insert = new StringBuilder("------------ Id search --------------\r\n")
                .append("Item NOT found.\n\r\n")
                .toString();
        testing(insert);
    }

    @Test
    public void whenSelectByExistingNameThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Item third = tracker.add(new Item("один", "третья заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", first.getName(), "y"});
        new StartUI(input, tracker).init();

        String insert = new StringBuilder("------------ Search item by name --------------\r\n")
                .append("------------ Items found:  name description id --------------\r\n")
                .append(String.format("%s %s %s\r\n", first.getName(), first.getDesc(), first.getId()))
                .append(String.format("%s %s %s\r\n", first.getName(), third.getDesc(), third.getId()))
                .append("---------------------------------------------------------\n\r\n")
                .toString();
        testing(insert);
    }

    @Test
    public void whenTrySelectByNonExistingNameThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Item third = tracker.add(new Item("один", "третья заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", "222", "y"});
        new StartUI(input, tracker).init();

        String insert = new StringBuilder("------------ Search item by name --------------\r\n")
                .append("Item NOT found.\r\n")
                .append("---------------------------------------------------------\n\r\n")
                .toString();

        testing(insert);
    }
}