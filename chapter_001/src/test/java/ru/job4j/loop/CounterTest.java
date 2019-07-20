package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    Counter counter = new Counter();
    @Test
    public void whenSumEvenNumbersFromTwelveToNineteenThenSixteen(){
        int result = counter.add(12, 19);
        assertThat(result,is(60));
    }

    @Test
    public void whenSumEvenNumbersFromTwelveToThreeThenFourty(){

        int result = counter.add(12, 3);
        assertThat(result,is(40));
    }

    @Test
    public void whenSumEvenNumbersFromTwelveToTwelweThenTwentyFourNumbersEven(){

        int result = counter.add(12, 12);
        assertThat(result,is(24));
    }

    @Test
    public void whenSumEvenNumbersFromNineToNineThenZeroNumbersOdd(){

        int result = counter.add(9, 9);
        assertThat(result,is(0));
    }
}
