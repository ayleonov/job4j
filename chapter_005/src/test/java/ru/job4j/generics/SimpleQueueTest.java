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
    public void whenAddFiveElementsThenReceiveItFIFO() {

        sq.push(3);
        sq.push(4);
        sq.push(5);

        //System.out.println("колич элементов: "+sq.firstStack.dcl.countelements());
        sq.convert();
        //System.out.println("колич элементов: "+sq.secondStack.dcl.countelements());
        assertThat(sq.secondStack.poll(), is(1));
        assertThat(sq.secondStack.poll(), is(2));
        assertThat(sq.secondStack.poll(), is(3));
    }


}
