package ru.job4j.tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.*;


public class TrackerSingletonsTest {
    @Test
    public void whenTryTwoOnSingletonOnTrackerSingleFirst() {
        TrackerSingleFirst first = TrackerSingleFirst.INSTANCE;
        TrackerSingleFirst second = TrackerSingleFirst.INSTANCE;
        assertTrue(first == second);
    }

    @Test
    public void whenTryTwoOnSingletonOnTrackerSingleSecond() {
        TrackerSingleSecond first = TrackerSingleSecond.getInstance();
        TrackerSingleSecond second = TrackerSingleSecond.getInstance();

        assertTrue(first == second);
    }

    @Test
    public void whenTryTwoOnSingletonOnTrackerSingleThird() {
        TrackerSingleThird first = TrackerSingleThird.getInstance();
        TrackerSingleThird second = TrackerSingleThird.getInstance();

        assertTrue(first == second);
    }

    @Test
    public void whenTryTwoOnSingletonOnTrackerSingleFourth() {
        TrackerSingleFourth first = TrackerSingleFourth.getInstance();
        TrackerSingleFourth second = TrackerSingleFourth.getInstance();

        assertTrue(first == second);
    }

}
