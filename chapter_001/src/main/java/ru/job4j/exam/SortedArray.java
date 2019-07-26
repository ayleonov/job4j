package ru.job4j.exam;

public class SortedArray {
    boolean isSorted(int[] value) {
        for (int i = 0; i < value.length - 1; i++) {
            if (value[0] <= value[1]) {
                if (value[i] > value[i + 1])
                    return false;
            } else if (value[0] >= value[1]) {
                if (value[i] < value[i + 1])
                    return false;
            }
        }
        return true;
    }
}
