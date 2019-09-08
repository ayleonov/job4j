package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;
    private final Consumer<String> output = new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println(s);

        }
    };

    private String showConsole(String insert) {
        String result = new StringBuilder()
                .append("0. Add new item")
                .append(System.lineSeparator())
                .append("1. Show all items")
                .append(System.lineSeparator())
                .append("2. Edit item")
                .append(System.lineSeparator())
                .append("3. Delete item")
                .append(System.lineSeparator())
                .append("4. Find item by id")
                .append(System.lineSeparator())
                .append("5. Find items by name")
                .append(System.lineSeparator())
                .append("6. Exit program")
                .append(System.lineSeparator())
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
        new StartUI(input, tracker, output).init();

        //menu.
        Item[] items = {first, second, new Item("три", "третья заявка", System.currentTimeMillis())};
        List<Item> result = tracker.findAll();
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i).getName(), is(items[i].getName()));
            assertThat(result.get(i).getDesc(), is(items[i].getDesc()));
        }
    }

    @Test
    public void whenUserAddItemThenTrackerInListHasItemWithTheSameNameAndDescription() {
        Tracker tracker = new Tracker();

        Input input = new StubInput(new String[]{"0", "один", "первая заявка", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("один"));
        assertThat(tracker.findAll().get(0).getDesc(), is("первая заявка"));
    }

    @Test
    public void whenSelectAllThenTrackerShowItemFirstSecond() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker, output).init();

        List<Item> expected = new ArrayList();
        expected.add(first);
        expected.add(second);
        assertThat(tracker.findAll(), is(expected));
    }


    @Test
    public void whenEditThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", first.getId(), "тест замены", "заменили заявку", "y"});
        new StartUI(input, tracker, output).init();

        Item[] items = {first, second};
        items[0].setName("тест замены");
        items[0].setDesc("заменили заявку");
        List<Item> result = tracker.findAll();
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i).getName(), is(items[i].getName()));
            assertThat(result.get(i).getName(), is(items[i].getName()));
        }
    }

    @Test
    public void whenDeleteThenFirstItemChangeToSecond() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", first.getId(), "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("два"));
    }

    @Test
    public void whenDeleteThenFirstItemChangeToSecond2() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", first.getId(), "y"});
        new StartUI(input, tracker, output).init();
        List<Item> expected = new ArrayList<Item>();
        expected.add(second);
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenSelectByIdItemHasIdThenEqualWithName() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", first.getId(), "y"});
        new StartUI(input, tracker, output).init();
        List<Item> expected = new ArrayList();
        expected.add(first);
        expected.add(second);
        assertThat(tracker.findAll(), is(expected));
//        assertThat(tracker.findAll(), is(new Item[]{first, second}));


    }

    @Test
    public void whenSelectByNamesOf3ItemsThenFound2Matches() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Item third = tracker.add(new Item("один", "третья заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", first.getName(), "y"});
        new StartUI(input, tracker, output).init();
        Item itemFirst = (tracker.findByName(first.getName())).get(0);
        Item itemSecond = (tracker.findByName(first.getName())).get(1);
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
        new StartUI(input, tracker, output).init();


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
        new StartUI(input, tracker, output).init();

        String insert = new StringBuilder(
                "---------------Items found (name description id): --------------")
                .append(System.lineSeparator())
                .append(String.format("один первая заявка %s", first.getId()))
                .append(System.lineSeparator())
                .append(String.format("два вторая заявка %s", second.getId()))
                .append(System.lineSeparator())
                .append("--------------------------------------------")
                .append(System.lineSeparator())
                .toString();

        testing(insert);
    }

    @Test
    public void whenEditThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", first.getId(), "тест замены", "заменили заявку", "y"});
        new StartUI(input, tracker, output).init();

        String insert = new StringBuilder("------------ Edit of item --------------")
                .append(System.lineSeparator())
                .append("------------ Edited item: --------------")
                .append(System.lineSeparator())
                .append("тест замены заменили заявку")
                .append(System.lineSeparator())
                .append("------------ Item replaced --------------")
                .append(System.lineSeparator())
                .toString();

        testing(insert);
    }


    @Test
    public void whenDeleteExistingItemThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", first.getId(), "y"});
        new StartUI(input, tracker, output).init();


        String insert = new StringBuilder("-------------- Delete item --------------")
                .append(System.lineSeparator())
                .append("\n---------- Item deleted -------------")
                .append(System.lineSeparator())
                .append("-----------------------------------------")
                .append(System.lineSeparator())
                .toString();

        testing(insert);
    }

    @Test
    public void whenTryDeleteNonExistingItemThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", "222", "y"});
        new StartUI(input, tracker, output).init();


        String insert = new StringBuilder("-------------- Delete item --------------")
                .append(System.lineSeparator())
                .append("Item not founded.")
                .append(System.lineSeparator())
                .append("-----------------------------------------")
                .append(System.lineSeparator())
                .toString();

        testing(insert);
    }

    @Test
    public void whenSelectExistingItemByIdThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", first.getId(), "y"});
        new StartUI(input, tracker, output).init();

        String insert = new StringBuilder("------------ Id search --------------")
                .append(System.lineSeparator())
                .append(String.format("------------ Item found: %s %s --------------", first.getName(), first.getDesc()))
                .append(System.lineSeparator())
                .toString();

        testing(insert);
    }

    @Test
    public void whenTrySelectNonExistingItemByIdThenPrinting() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", "222", "y"});
        new StartUI(input, tracker, output).init();

        String insert = new StringBuilder("------------ Id search --------------")
                .append(System.lineSeparator())
                .append("Item NOT found.\n")
                .append(System.lineSeparator())
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
        new StartUI(input, tracker, output).init();

        String insert = new StringBuilder("------------ Search item by name --------------")
                .append(System.lineSeparator())
                .append("------------ Items found:  name description id --------------")
                .append(System.lineSeparator())
                .append(String.format("%s %s %s", first.getName(), first.getDesc(), first.getId()))
                .append(System.lineSeparator())
                .append(String.format("%s %s %s", first.getName(), third.getDesc(), third.getId()))
                .append(System.lineSeparator())
                .append("---------------------------------------------------------")
                .append(System.lineSeparator())
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
        new StartUI(input, tracker, output).init();

        String insert = new StringBuilder("------------ Search item by name --------------")
                .append(System.lineSeparator())
                .append("Item NOT found.")
                .append(System.lineSeparator())
                .append("---------------------------------------------------------")
                .append(System.lineSeparator())
                .toString();

        testing(insert);
    }
}