package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenTriangle12_13_27ThenNotExist() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(2, 0), new Point(0, 2));
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 2));
    }
}
