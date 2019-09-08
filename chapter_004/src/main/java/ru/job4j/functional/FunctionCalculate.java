package ru.job4j.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// y = ax + b;
// y = ax2 + bx + c;
// y = log a(x) = ln(x)/ln(a) ;

public class FunctionCalculate {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(func.apply(i * 1.0));
        }
        return result;
    }
}
