package ru.job4j.exam;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortnumberTest {
    @Test
    public void whenExistEvenAndOddNumbers() {
        Sortnumber sn = new Sortnumber();
        int[] numbers = {2, 4, 6, 3, 7, 5};
        int result = sn.sortarray(numbers);
        assertThat(result, is(56));
    }

    @Test
    public void whenExistOnlyOddNumbers() {
        Sortnumber sn = new Sortnumber();
        int[] numbers = {21, 41, 61, 3, 7, 5};
        int result = sn.sortarray(numbers);
        assertThat(result, is(0));
    }
}
