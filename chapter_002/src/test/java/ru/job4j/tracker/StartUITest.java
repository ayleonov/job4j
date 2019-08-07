package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasItemWithTheSameName() throws Exception {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "один", "первая заявка", "6"});
        new StartUI(input, tracker).init();
        Item[] items = {new Item("один", "первая заявка", System.currentTimeMillis())};
        Item[] result = tracker.findAll();
        for (int i = 0; i < result.length ; i++) {
           assertThat(result[i].getName(),is(items[i].getName()));
           assertThat(result[i].getDesc(),is(items[i].getDesc()));
        }
    }

    @Test
    public void whenUserAddItemThenTrackerInListHasItemWithTheSameNameAndDescription() throws Exception {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "один", "первая заявка", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("один"));
        assertThat(tracker.findAll()[0].getDesc(), is("первая заявка"));
    }

    @Test
    public void whenEditThenTrackerHasUpdatedValue() throws Exception {
        Tracker tracker = new Tracker();
        Item item = (new Item("один", "первая заявка", System.currentTimeMillis()));
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "тест замены", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        Item[] items = {item};
        items[0].setName("тест замены");
        items[0].setDesc("заменили заявку");
        Item[] result = tracker.findAll();
        for (int i = 0; i < result.length ; i++) {
            assertThat(result[i].getName(),is(items[i].getName()));
            assertThat(result[i].getName(),is(items[i].getName()));
        }
    }

    @Test
    public void whenDeleteThenFirstItemChangeToSecond() throws Exception {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", first.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("два"));
    }
    @Test
    public void whenDeleteThenFirstItemChangeToSecond2() throws Exception {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", first.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Item[]{second}));
    }

    @Test
    public void whenSelectByIdItemHasIdThenEqualWithName() throws Exception {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Item[]{item}));
    }

    @Test
    public void whenSelectByNamesOf3ItemsThenFound2Matches() throws Exception {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("один", "первая заявка", System.currentTimeMillis()));
        Item second = tracker.add(new Item("два", "вторая заявка", System.currentTimeMillis()));
        Item third = tracker.add(new Item("один", "третья заявка", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", first.getName(), "6"});
        new StartUI(input, tracker).init();
        Item itemFirst = (tracker.findByName(first.getName()))[0];
        Item itemSecond = (tracker.findByName(first.getName()))[1];
        assertThat(itemFirst.getName(), is("один"));
        assertThat(itemFirst.getDesc(), is("первая заявка"));
        assertThat(itemSecond.getName(), is("один"));
        assertThat(itemSecond.getDesc(), is("третья заявка"));
    }
}