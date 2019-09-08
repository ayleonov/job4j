package ru.job4j.functional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionCalculateTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculate function = new FunctionCalculate();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculate function = new FunctionCalculate();
        List<Double> result = function.diapason(1, 4, x -> (Math.pow(x, 2) + 3 * x + 2));
        List<Double> expected = Arrays.asList(6D, 12D, 20D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        FunctionCalculate function = new FunctionCalculate();
        List<Double> result = function.diapason(5, 8, x -> Math.log(x) / Math.log(5));
        double a = Math.log(5) / Math.log(5);
        double b = Math.log(6) / Math.log(5);
        double c = Math.log(7) / Math.log(5);

        List<Double> expected = Arrays.asList(a, b, c);
        assertThat(result, is(expected));
    }
}
