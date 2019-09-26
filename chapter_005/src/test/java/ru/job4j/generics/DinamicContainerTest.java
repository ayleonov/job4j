package ru.job4j.generics;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;


public class DinamicContainerTest {
    private DinamicContainer<Integer> dincont;

    @Before
    public void beforeTest() {
        dincont = new DinamicContainer<>();
        dincont.add(1);
        dincont.add(2);
    }

    @Test
    public void whenAddTenElementsThenItInContainer() {
        // проверка заполнения начального массива:
        dincont.add(3);
        dincont.add(4);
        dincont.add(5);
        dincont.add(6);
        dincont.add(7);
        dincont.add(8);
        dincont.add(9);
        assertThat(dincont.getContainer()[8], is(9));
        dincont.add(10);
        assertThat(dincont.getContainer()[9], is(10));
        // проверка длины массива до увеличения:
        assertThat(dincont.getContainer().length, is(10));
        // проверка добавления в увеличенный массив:
        dincont.add(11);
        assertThat(dincont.getContainer()[10], is(11));
        // проверка длины массива после увеличения:
        assertThat(dincont.getContainer().length, is(15));
        dincont.add(12);
        assertThat(dincont.getContainer()[11], is(12));
    }

    @Test
    public void whenAddTwoElementsThenGetSecondByIndex() {
        assertThat(dincont.get(1), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestingHasNextAndNext() {
        Iterator it = dincont.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}