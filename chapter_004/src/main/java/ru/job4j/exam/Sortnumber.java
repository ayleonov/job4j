package ru.job4j.exam;

import java.util.Arrays;

public class Sortnumber {
    public int sortarray(int[] numbers) {
        return Arrays.stream(numbers).filter(r -> r % 2 == 0).map(r -> r * r).reduce(0, Integer::sum);
    }
}
