package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenZeroAndTenThenTen() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 10);
        double result = first.distance(second);
        first.info();
        second.info();
        System.out.println(String.format("Result is: %s", result));
        assertThat(result, is(10D));
    }

    @Test
    public void whenCheckItself() {
        Point point = new Point(0, 0);
        double result = point.distance(point);
        assertThat(result, is(0D));
    }

    @Test
    public void whenShowInfo() {
        Point first = new Point(1, 1);
        first.info();
        Point second = new Point(2, 2);
        second.info();
    }

    @Test
    public void whenCheckItself3d() {
        Point point = new Point(0, 0, 0);
        double result = point.distance3d(point);
        assertThat(result, is(0D));
    }

    @Test
    public void whenZeroAndThreeAndFourThenFive() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(0, 3, 4);
        double result = first.distance3d(second);
        System.out.println(String.format("Result is: %s", result));
        assertThat(result, is(5D));
    }


}