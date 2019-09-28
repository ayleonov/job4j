package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    private SimpleQueue<Integer> sq;

    @Before
    public void beforeTest() {
        sq = new SimpleQueue();
        sq.push(1);
        sq.push(2);
    }

    @Test
    public void whenAddTenElementsThenItInContainer() {

        sq.push(3);
        sq.push(4);
        sq.push(5);
        System.out.println(sq.getElementsFromLast(0));
        System.out.println(sq.getElementsFromLast(1));

        assertThat(sq.getElementsFromLast(0), is(1));
        assertThat(sq.getElementsFromLast(1), is(2));


    }

    @Test
    public void whenAddTwoElementsThenGetFirstByIndex() {
        assertThat(sq. simpstack.get(1), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestingHasNextAndNext() {
        Iterator it = sq.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenDeletedAndReceiveElement() {
        sq.poll();
        assertThat(sq.poll(), is(2));
        assertThat(sq.simpstack.get(0), is(1));
    }
}
