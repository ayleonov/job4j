package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstIsMax() {
        Max max = new Max();
        int result = max.max(3, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenSecondIsMax() {
        Max max = new Max();
        int result = max.max(32, 52);
        assertThat(result, is(52));
    }

    @Test
    public void whenFirstSecondEquals() {
        Max max = new Max();
        int result = max.max(13, 13);
        assertThat(result, is(13));
    }
}
