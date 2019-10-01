package ru.job4j.generics;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    @Test
    public void whenTryAddNewElement() {
        SimpleSet<Integer> sset = new SimpleSet();
        boolean result = sset.add(14);

        assertThat(sset.getSa().getArray()[0], is(14));
        assertThat(result, is(true));
    }

    @Test
    public void whenTryAddDublicat() {
        SimpleSet<Integer> sset = new SimpleSet();
        sset.add(14);
        boolean result = sset.add(14);
        assertThat(sset.getSa().getArray()[0], is(14));
        assertThat(result, is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestingIterator() {
        SimpleSet<Integer> sset = new SimpleSet();
        Iterator it = sset.iterator();
        sset.add(14);
        sset.add(7);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(14));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}