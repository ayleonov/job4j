package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimeNumberTest {
    @Test
    public void when5(){
    PrimeNumber number = new PrimeNumber();
    int result = number.calc(5);
    assertThat(result,is(3));
    }

    @Test
    public void when11(){
        PrimeNumber number = new PrimeNumber();
        int result = number.calc(11);
        assertThat(result,is(5));
    }

    @Test
    public void when1(){
        PrimeNumber number = new PrimeNumber();
        int result = number.calc(2);
        assertThat(result,is(1));
    }

}
