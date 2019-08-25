package ru.job4j.exam;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class CofemachineTest {
    @Test
    public void whenChangeIsZero() {
        Cofemachine machine = new Cofemachine();
        int[] result = machine.changes(50, 50);
        assertThat(result, is(new int[]{}));
    }

    @Test
    public void whenValue50Price35Then10_5() {
        Cofemachine machine = new Cofemachine();
        int[] result = machine.changes(50, 35);
        assertThat(result, is(new int[]{10, 5}));
    }

    @Test
    public void whenValue73Price35Then10_10_10_5_2_1() {
        Cofemachine machine = new Cofemachine();
        int[] result = machine.changes(73, 35);
        assertThat(result, is(new int[]{10, 10, 10, 5, 2, 1}));
    }
}
