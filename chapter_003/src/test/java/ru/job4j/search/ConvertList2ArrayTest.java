package ru.job4j.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenElementsFrom3ArraysConvertInTotalList() {
        List<int[]> list = new ArrayList();
        int[] arrayFirst = {1, 2};
        int[] arraySecond = {3, 4, 5, 6};
        int[] arrayThird = {7, 8, 9};

        list.add(arrayFirst);
        list.add(arraySecond);
        list.add(arrayThird);
        ConvertList2Array listBefore = new ConvertList2Array();
        List<Integer> convertedList = listBefore.convert(list);
        List<Integer> expected = new ArrayList();
        for (int i = 1; i <= 9; i++) {
            expected.add(i);
        }
        assertThat(convertedList, is(expected));
    }
}