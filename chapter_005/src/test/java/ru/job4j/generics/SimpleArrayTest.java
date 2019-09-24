package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void whenAddStringTest() {
        SimpleArray<String> sa = new SimpleArray<>(5);
        sa.add("test");

        assertThat(sa.getArray()[0], is("test"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTryAddElementAboveLimitThenException() {
        SimpleArray<String> sa = new SimpleArray<>(2);
        sa.add("test");
        sa.add("test2");
        sa.add("test3");
    }

    @Test
    public void whenInsertStringTest2OnBusyIndex() {
        SimpleArray<String> sa = new SimpleArray<>(5);
        sa.add("test");
        boolean result = sa.set(0, "test2");
        assertThat(result, is(true));
        assertThat(sa.getArray()[0], is("test2"));
    }

    @Test
    public void whenRemoveStringFromIndex1ThenOtherPartMoves() {
        SimpleArray<String> sa = new SimpleArray<>(7);
        sa.add("test");
        sa.add("test2");
        sa.add("test3");
        sa.add("test4");
        sa.add("test5");
        boolean result = sa.remove(1);
        assertThat(result, is(true));
        assertThat(sa.getArray()[1], is("test3"));
        assertThat(sa.getArray()[2], is("test4"));

    }

    @Test
    public void whenRemoveNumberFromIndex1ThenOtherPartMoves() {
        SimpleArray<Integer> sa = new SimpleArray<>(7);
        sa.add(0);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.add(4);
        sa.remove(1);
        assertThat(sa.getArray()[1], is(2));
        assertThat(sa.getArray()[2], is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoElementsThenHasNextFalse() {
        SimpleArray<String> sa = new SimpleArray<>(7);
        Iterator it = sa.iterator();
        assertThat(it.hasNext(), is(false));
        sa.add("text4");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("text4"));
        it.next();
    }

    @Test
    public void whenLaunchFirstTimeIteratorSecondTimeThenReceiveFirstElement() {
        SimpleArray<Integer> sa = new SimpleArray<>(7);
        sa.add(0);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.add(4);
        Iterator it = sa.iterator();
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
    }


}