package ru.job4j.io;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SearchByCriteriaTest {
    String source = "c:/temp/tmpdir/";
    SearchByCriteria sbc = new SearchByCriteria(source);

    @Test
    public void when() {
    sbc.start();

    }
}