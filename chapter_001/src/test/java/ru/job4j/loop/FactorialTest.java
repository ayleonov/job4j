package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    @Test
    public void whenFactorialFiveThenOneHundredTwenty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenFactorialZeroThenOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }

    @Test
    public void whenFactorialFourThenTwentyFour() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(4);
        assertThat(result, is(24));
    }

    @Test
    public void whenFactorialSixThenSevenHundredTwenty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(6);
        assertThat(result, is(720));
    }

    @Test
    public void whenFactorialSevenThenFiveThousandForty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(7);
        assertThat(result, is(5040));
    }
}
