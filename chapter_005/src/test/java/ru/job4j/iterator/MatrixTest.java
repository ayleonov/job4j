package ru.job4j.iterator;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MatrixTest {
    @Test(expected = NoSuchElementException.class)
    public void whenTestingSquareMatrixTwoOnTwo() {
        int[][] value = {
                {1, 2},
                {3, 4}
        };
        Matrix matr = new Matrix(value);
        Iterator it = matr.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        it.hasNext();
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenTestingNonSquareMatrix() {
        int[][] value = {{1}, {2, 3, 4, 5}, {6, 7}, {8, 9, 10, 11, 12, 13, 14}};
        Matrix matr = new Matrix(value);
        Iterator it = matr.iterator();

        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(11));
        assertThat(it.next(), is(12));
    }
}