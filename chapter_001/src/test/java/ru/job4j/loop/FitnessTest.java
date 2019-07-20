package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FitnessTest {
    @Test
    public void whenIvanGreatNick() {
        Fitness fitness = new Fitness();
        int result = fitness.calc(95, 90);

        assertThat(result, is(0));
    }

    @Test
    public void whenIvanByOneNick() {
        Fitness fitness = new Fitness();
        int result = fitness.calc(90, 95);

        assertThat(result, is(1));
    }

    @Test
    public void whenIvanLessByFewNick() {
        Fitness fitness = new Fitness();
        int result = fitness.calc(50, 90);

        assertThat(result, is(2));
    }
}
