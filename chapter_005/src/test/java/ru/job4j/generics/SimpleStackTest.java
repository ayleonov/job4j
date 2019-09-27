package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class SimpleStackTest {
    private SimpleStack<Integer> dincont;

    @Before
    public void beforeTest() {
        dincont = new SimpleStack<>();
        dincont.push(1);
        dincont.push(2);
    }

    @Test
    public void whenAddTenElementsThenItInContainer() {

        dincont.push(3);
        dincont.push(4);
        dincont.push(5);

        assertThat(dincont.get(0), is(5));
        assertThat(dincont.get(1), is(4));

    }

    @Test
    public void whenAddTwoElementsThenGetFirstByIndex() {
        assertThat(dincont.get(1), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestingHasNextAndNext() {
        Iterator it = dincont.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenDeletedAndReceiveElement() {
        assertThat(dincont.poll(), is(2));
        assertThat(dincont.get(0), is(1));
    }
}
