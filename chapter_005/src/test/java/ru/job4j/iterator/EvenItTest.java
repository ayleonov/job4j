package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class EvenItTest {
    EvenIt it;
    EvenIt it2;

    @Before
    public void setUp() {
        it = new EvenIt(new int[]{7, 8, 9, 14, 3});
        it2 = new EvenIt(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public void whenHaveNumbers789And14and3ThenEven8And14() {
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(14));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(it2.hasNext(), is(true));
        assertThat(it2.next(), is(2));
        assertThat(it2.hasNext(), is(true));
        assertThat(it2.next(), is(4));
        assertThat(it2.hasNext(), is(true));
        assertThat(it2.next(), is(6));
        assertThat(it2.hasNext(), is(false));
        it2.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it2.hasNext(), is(true));
        assertThat(it2.hasNext(), is(true));
        assertThat(it2.next(), is(2));
        assertThat(it2.next(), is(4));
        assertThat(it2.next(), is(6));
    }

    @Test
    public void shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenIt(new int[]{1});
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void shouldReturnTrueIfOnlyOneEvenNumber() {
        it = new EvenIt(new int[]{2});
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void allNumbersAreEven() {
        it = new EvenIt(new int[]{2, 4, 6, 8});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }
}