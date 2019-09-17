package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DepartmentTest {
    @Test
    public void whenStandartSorting() {
        String[] departments = {"K1", "K2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2",
                "K2\\SK1"};
        Department dp = new Department();
        String[] result = dp.sorting(departments);
        String[] expect = {"K1", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2",
                "K2\\SK1"};
        assertThat(result, is(expect));
    }

    @Test
    public void whenReverseSorting() {
        String[] departments = {"K1", "K2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2",
                "K2\\SK1"};
        Department dp = new Department();
        String[] result = dp.sortingReverse(departments);
        String[] expect = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        assertThat(result, is(expect));
    }
}
