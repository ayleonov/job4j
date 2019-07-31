package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);

        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }


    @Test
    public void whenDeleteThenNextItemOnPreviousPlace() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "test2Description", 1221L);
        Item third = new Item("test3", "testDescription", 12321L);
        Item fourth = new Item("test4", "test2Description", 122211L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        String idFirst = first.getId();
        String idSecond = second.getId();
        String idThird = second.getId();
        String idFourth = second.getId();
        int indexfirst = tracker.findIndexThroughId(idFirst);
        tracker.delete(idFirst);
        int indexsecond = tracker.findIndexThroughId(idSecond);
        assertThat(indexfirst, is(indexsecond));
        assertThat(indexsecond-indexfirst, is(0) );
    }

    @Test
    public void whenDeleteIndexfirstDeletedThenTrue() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        boolean result = tracker.delete(first.getId());
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteMockIdThenFalse() {
        Tracker tracker = new Tracker();
        Item mock = new Item("test1", "testDescription", 123L);
        boolean result = tracker.delete(mock.getId());
        assertThat(result, is(false));
    }

    @Test
    public void whenItemsFindIndexThroughIdThen0() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "test2Description", 1221L);
        tracker.add(first);
        tracker.add(second);
        String idFirst = first.getId();
        String idSecond = second.getId();
        int indexfirst = tracker.findIndexThroughId(idFirst);
        assertThat(indexfirst, is(0));
    }

    @Test
    public void whenItemsFindIndexThroughIdThen1() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "test2Description", 1221L);
        tracker.add(first);
        tracker.add(second);
        String idFirst = first.getId();
        String idSecond = second.getId();
        int indexsecond = tracker.findIndexThroughId(idSecond);
        assertThat(indexsecond, is(1));
    }

    @Test
    public void whenfindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "test2Description", 1221L);
        Item third = new Item("test3", "testDescription", 1253L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        Item[] result = tracker.findAll();
        Item[] expected = new Item[100];
        expected[0] = first;
        expected[1] = second;
        expected[2] = third;
        assertThat(result.length, is(3));
        assertThat(result[0], is(expected[0]));
        assertThat(result[1], is(expected[1]));
        assertThat(result[2], is(expected[2]));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 123L);
        Item third = new Item("test2", "testDescription", 123L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);

        Item[] result = {second, third};
        Item[] expected = tracker.findByName("test2");

        assertThat(result, is(expected));
    }
}
