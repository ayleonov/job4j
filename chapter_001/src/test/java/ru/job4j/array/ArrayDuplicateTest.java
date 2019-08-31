package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] input = {"one", "two", "three", "one", "two", "five", "four"};
        String[] result = array.remove(input);
        assertThat(result, is(new String[]{"one", "two", "three", "five", "four"}));
    }
}
