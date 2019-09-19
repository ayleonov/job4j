package ru.job4j.exam;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class OrgTest {
    @Test
    public void whenDirectSorting() {
        Org firstSorting = new Org();
        firstSorting.sorting(0);
        List<String> result = firstSorting.getNamestring();
        String[] expect = {"K1", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K2","K2\\SK1\\SSK1", "K2\\SK1\\SSK2",
                "K2\\SK1"};
        assertThat(result, is(expect));
    }
    @Test
    public void whenReverseSorting() {
        Org firstSorting = new Org();
        firstSorting.sorting(0);
        List<String> result = firstSorting.getNamestring();
        String[] expect = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        assertThat(result, is(expect));
    }
}
