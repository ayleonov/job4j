package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void when12345Then54321() {
        Turn turn = new Turn();
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] result = turn.back(input);
        assertThat(result, is(new int[]{5, 4, 3, 2, 1}));
    }
    @Test
    public void when4162Then2614() {
        Turn turn = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turn.back(input);
        assertThat(result, is(new int[]{2, 6, 1, 4}));
    }


    @Test
    public void when4162311Then1132614() {
        Turn turn = new Turn();
        int[] input = new int[]{4, 1, 6, 2, 3, 11};
        int[] result = turn.back(input);
        assertThat(result, is(new int[]{11, 3, 2, 6, 1, 4}));
    }
}