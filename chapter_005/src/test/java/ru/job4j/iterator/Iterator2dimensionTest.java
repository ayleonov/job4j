package ru.job4j.iterator;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class Iterator2dimensionTest {
    Iterator2dimension<Integer> it;

    @Before
    public void setUp() {
        it = new Iterator2dimension(new int[][]{{1}, {3, 4}, {7}});
    }

    @Test
    public void when1() {
        int[][] values = new int[][]{{1, 2}, {3, 4}};
        Iterator2dimension idi = new Iterator2dimension(values);

        assertThat(idi.next(), is(1));
        assertThat(idi.next(), is(2));
        assertThat(idi.next(), is(3));
        assertThat(idi.next(), is(4));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }

}