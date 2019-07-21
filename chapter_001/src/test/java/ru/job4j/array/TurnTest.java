package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    // тестирование метода общего случая
    @Test
    public void when12345Then54321() {
        Turn turn = new Turn();
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] result = turn.back(input);
        assertThat(result, is(new int[]{5, 4, 3, 2, 1}));
    }

    // тестирование метода общего случая
    @Test
    public void when4162Then2614() {
        Turn turn = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turn.back(input);
        assertThat(result, is(new int[]{2, 6, 1, 4}));
    }

    // тестирование метода для нечетного числа элементов массива
    @Test
    public void when12345Then54321Even() {
        Turn turn = new Turn();
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] result = turn.backEven(input);
        assertThat(result, is(new int[]{5, 4, 3, 2, 1}));
    }

    // тестирование метода для четного числа элементов массива
    @Test
    public void when12345Then54321Odd() {
        Turn turn = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turn.back(input);
        assertThat(result, is(new int[]{2, 6, 1, 4}));
    }
}
