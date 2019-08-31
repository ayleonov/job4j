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

    @Test
    public void when12And14And15Then15() {
        Max maximum = new Max();
        int result = maximum.max(13, 13, 15);
        assertThat(result, is(15));
    }

    @Test
    public void when32And14And15Then32() {
        Max maximum = new Max();
        int result = maximum.max(32, 14, 32);
        assertThat(result, is(32));
    }

    @Test
    public void when12And12And12Then12() {
        Max maximum = new Max();
        int result = maximum.max(12, 12, 12);
        assertThat(result, is(12));
    }

    @Test
    public void when0And12And61And74Then74() {
        Max maximum = new Max();
        int result = maximum.max(0, 12, 61, 74);
        assertThat(result, is(74));
    }

    @Test
    public void when12And34And0And1Then34() {
        Max maximum = new Max();
        int result = maximum.max(12, 34, 0, 1);
        assertThat(result, is(34));
    }

    @Test
    public void when22And12And1And3Then22() {
        Max maximum = new Max();
        int result = maximum.max(22, 12, 1, 3);
        assertThat(result, is(22));
    }

}
