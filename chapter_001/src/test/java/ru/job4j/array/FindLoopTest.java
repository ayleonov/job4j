package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenArrayHas5Then0() {
        FindLoop findLoop = new FindLoop();
        int[] array = {5, 10, 3};
        int result = findLoop.indexOf(array, 5);
        assertThat(result, is(0));
    }

    @Test
    public void whenArrayHas20Then2() {
        FindLoop find = new FindLoop();
        int[] input = {5, 10, 20, 21, 43};
        int result = find.indexOf(input, 20);
        assertThat(result, is(2));
    }

    @Test
    public void whenArrayHas54Then5() {
        FindLoop find = new FindLoop();
        int[] input = {5, 10, 20, 15, 32, 54};
        int result = find.indexOf(input, 54);
        assertThat(result, is(5));
    }

    @Test
    public void whenArrayHasNot3() {
        FindLoop find = new FindLoop();
        int[] input = {5, 10, 20};
        int result = find.indexOf(input, 3);
        assertThat(result, is(-1));
    }

    @Test
    public void whenFind3() {
        FindLoop find = new FindLoop();
        int[] input = {5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = find.indexOf(input, value, start, finish);
        assertThat(result, is(3));
    }

    @Test
    public void whenFind10() {
        FindLoop find = new FindLoop();
        int[] input = {5, 2, 10, 2, 4};
        int value = 3;
        int start = 2;
        int finish = 4;
        int result = find.indexOf(input, value, start, finish);
        assertThat(result, is(-1));
    }

    @Test
    public void whenSort5() {
        FindLoop find = new FindLoop();
        int[] input = {3, 4, 1, 2, 5};

        int[] result = find.sort(input);
        int[] expect = {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort6() {
        FindLoop find = new FindLoop();
        int[] input = {3, 4, 1, 2, 5, 2};

        int[] result = find.sort(input);
        int[] expect = {1, 2, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort3() {
        FindLoop find = new FindLoop();
        int[] input = {3, 4, 1};
        int[] result = find.sort(input);
        int[] expect = {1, 3, 4};
        assertThat(result, is(expect));
    }
}
