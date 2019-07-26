package ru.job4j.loop;

public class Counter {
    public int add(int start, int finish) {
        int sum = 0;

        if (start < finish) {
            for (int i = start; i <= finish; i++) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
            return sum;
        } else if (start > finish) {
            for (int i = start; i >= finish; i--) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
        } else if (start % 2 == 0) {
            // ветвь при start = finish
            sum = 2 * start;
        } else {
            sum = 0;
        }
        return sum;
    }
}
