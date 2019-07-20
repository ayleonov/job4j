package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MortgageTest {
    @Test
    public void when1Year() {
        Mortgage mortgage = new Mortgage();
        int years = mortgage.year(1000, 100, 1.0);
        assertThat(years, is(1));
    }

    @Test
    public void when2Year() {
        Mortgage mortgage = new Mortgage();
        int years = mortgage.year(100, 10, 50.0);
        assertThat(years, is(2));
    }
}

