package ru.job4j.iterator;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class ArrayIteratorTest {
    private static final class ForEachIterator implements Iterable {
        private final int[] values;

        public ForEachIterator(int[] values) {
            this.values = values;
        }

        @Override
        public Iterator iterator() {
            return new ArrayIterator(values);
        }
    }


    @Test
    public void whenTryLaunchHasnext3() {
        int[] values = new int[]{1, 3};
        ArrayIterator ai = new ArrayIterator(values);
        ai.next();
        boolean result = ai.hasNext();
        assertThat(result, is(true));
        int resultInt = (Integer) ai.next();
        assertThat(resultInt, is(3));
    }

    @Test
    public void whenTryLaunchNext() {
        int[] values = new int[]{1};
        ArrayIterator ai = new ArrayIterator(values);
        ai.next();
        boolean result = ai.hasNext();
        assertThat(result, is(false));
    }

    @Test
    public void whenTryForEach() {
        ForEachIterator foreach = new ForEachIterator(new int[]{1, 2, 4, 5});
        for (Object value : foreach) {
            System.out.println(value);
        }


    }

}