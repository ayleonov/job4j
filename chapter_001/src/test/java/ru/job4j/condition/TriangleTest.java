package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Triangle triangle = new Triangle();
        Double result = triangle.area(0, 0, 0, 2, 2, 0);
        Double expected = 2D;
        assertThat(result, closeTo(expected, 2));
    }
}
