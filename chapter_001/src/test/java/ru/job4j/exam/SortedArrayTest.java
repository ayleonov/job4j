package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortedArrayTest {
    @Test
    public void whenArray123449ThenTrue() {
        SortedArray array = new SortedArray();
        int[] input = {1, 2, 3, 4, 4, 9};
        boolean result = array.isSorted(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenArray98552ThenTrue() {
        SortedArray array = new SortedArray();
        int[] input = {9, 8, 5, 5, 2};
        boolean result = array.isSorted(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenArray985562ThenFalse() {
        SortedArray array = new SortedArray();
        int[] input = {9, 8, 5, 5, 6, 2};
        boolean result = array.isSorted(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenArray125449ThenFalse() {
        SortedArray array = new SortedArray();
        int[] input = {1, 2, 5, 4, 4, 9};
        boolean result = array.isSorted(input);
        assertThat(result, is(false));
    }


}
