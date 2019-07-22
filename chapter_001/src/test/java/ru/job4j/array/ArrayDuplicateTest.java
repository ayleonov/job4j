package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate(){
        ArrayDuplicate arrDupl = new ArrayDuplicate();
        String[] input = new String[]{"one", "two", "three", "one", "two", "five", "four"};
        String[] result = arrDupl.remove(input);
        assertThat(result, is(new String[]{"one", "two", "three", "five", "four"}));
    }
}
