package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(27, 24, 21);
        assertThat(result, is(27));
    }

    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(17, 24, 21);
        assertThat(result, is(24));
    }

    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(17, 24, 31);
        assertThat(result, is(31));
    }

    @Test
    public void whenEquals() {
        MultiMax check = new MultiMax();
        int result = check.max(17, 17, 17);
        assertThat(result, is(17));
    }
}
