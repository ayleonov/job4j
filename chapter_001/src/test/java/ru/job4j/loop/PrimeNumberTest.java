package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimeNumberTest {
    @Test
    public void when5(){
    PrimeNumber primeNumber = new PrimeNumber();
    int number = primeNumber.calc(5);
    assertThat(number,is(3));
    }

    @Test
    public void when11(){
        PrimeNumber primeNumber = new PrimeNumber();
        int number = primeNumber.calc(11);
        assertThat(number,is(5));
    }

    @Test
    public void when1(){
        PrimeNumber primeNumber = new PrimeNumber();
        int number = primeNumber.calc(2);
        assertThat(number,is(1));
    }

}
