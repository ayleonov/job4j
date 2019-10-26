package ru.job4j.map;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;


public class OverridehashcodeTest {
    Overridehashcode ohc;

    @Test
    public void whenFieldIsBoolean() {
        boolean testfield = true;
        ohc = new Overridehashcode(testfield);
        ohc.hashCode();
        assertThat(ohc.hashCode(), is(32));

        boolean testfield2 = false;
        ohc = new Overridehashcode(testfield2);
        assertThat(ohc.hashCode(), is(31));
    }

    @Test
    public void whenFieldIsByteCharShortInt() {
        byte testfield = 0b01001;
        ohc = new Overridehashcode(testfield);
        assertThat(ohc.hashCode(), is(31 + (int) testfield));

        short testfield2 = 2155;
        ohc = new Overridehashcode(testfield2);
        assertThat(ohc.hashCode(), is(31 + (int) testfield2));

        char testfield3 = 't';
        ohc = new Overridehashcode(testfield3);
        assertThat(ohc.hashCode(), is(31 + (int) testfield3));

        int testfield4 = 152;
        ohc = new Overridehashcode(testfield4);
        assertThat(ohc.hashCode(), is(31 + testfield4));
    }

    @Test
    public void whenFieldIsLong() {
        long testfield = 2321L;
        int a = (int) testfield;
        ohc = new Overridehashcode(testfield);
        assertThat(ohc.hashCode(), is(31 + (a ^ a >>> 32)));
    }

    @Test
    public void whenFieldIsFloat() {
        float testfield = 2321F;
        int a = (int) testfield;
        ohc = new Overridehashcode(testfield);
        assertThat(ohc.hashCode(), is(31 + (Float.floatToIntBits(a))));
    }

    @Test
    public void whenFieldIsDouble() {
        double testfield = 2321D;
        int a = (int) testfield;
        ohc = new Overridehashcode(testfield);
        ohc.hashCode();
        assertThat(ohc.hashCode(), is(31 + (
                ((Long) Double.doubleToLongBits(a)).intValue())));
    }

    @Test
    public void whenFieldIsObject() {
        Object testfield = "23d3";
        ohc = new Overridehashcode(testfield);
        assertThat(ohc.hashCode(), is(31 + testfield.hashCode()));
    }
}