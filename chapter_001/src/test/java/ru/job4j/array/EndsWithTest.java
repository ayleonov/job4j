package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EndsWithTest {
    @Test
    public void whenEndsWithPostfixThenTrue() {
        EndsWith endsWith = new EndsWith();
        boolean result = endsWith.endsWith("Hello", "lo");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        EndsWith endsWith = new EndsWith();
        boolean result = endsWith.endsWith("Hello", "li");
        assertThat(result, is(false));
    }
}
