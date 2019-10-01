package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ResearchTest {
    @Test
    public void whenCreatedUsersWithoutOverrideEquals() {
        Research r1 = new Research();
        r1.researching();
    }
}
