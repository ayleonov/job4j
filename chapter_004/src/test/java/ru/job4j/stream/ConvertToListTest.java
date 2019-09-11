package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertToListTest {
    @Test
    public void whenMatrixConvertToList() {
        ConvertToList ctl = new ConvertToList();
        List<Integer> result = ctl.convert(new Integer[][]{{1, 2}, {3, 4}});
        assertThat(result, is(List.of(1, 2, 3, 4)));
    }
}