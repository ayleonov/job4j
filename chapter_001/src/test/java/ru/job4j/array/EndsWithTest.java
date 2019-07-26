package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EndsWithTest {
    @Test
    public void whenEndsWithPostfixThenTrue() {
        EndsWith ends = new EndsWith();
        boolean result = ends.endsWith("Hello", "lo");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        EndsWith ends = new EndsWith();
        boolean result = ends.endsWith("Hello", "li");
        assertThat(result, is(false));
    }
}
