package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenArrayHas5Then0() {
        FindLoop findLoop = new FindLoop();
        int[] array = new int[]{5, 10, 20};
        int result = findLoop.indexOf(array, 5);
        assertThat(result, is(0));
    }

    @Test
    public void whenArrayHas20Then2() {
        FindLoop findLoop = new FindLoop();
        int[] array = new int[]{5, 10, 20, 21, 43};
        int result = findLoop.indexOf(array, 20);
        assertThat(result, is(2));
    }

    @Test
    public void whenArrayHas54Then5() {
        FindLoop findLoop = new FindLoop();
        int[] array = new int[]{5, 10, 20, 15, 32, 54};
        int result = findLoop.indexOf(array, 54);
        assertThat(result, is(5));
    }

    @Test
    public void whenArrayHasNot3() {
        FindLoop findLoop = new FindLoop();
        int[] array = new int[]{5, 10, 20};
        int result = findLoop.indexOf(array, 3);
        assertThat(result, is(-1));
    }
}
