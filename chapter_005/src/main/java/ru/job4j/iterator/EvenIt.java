package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator {
    private final int[] numbers;
    private int index = -1;
    private int tempCode = 0;

    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {

        boolean result = false;
        for (int i = index + 1; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (tempCode == 1) {
                    index = i;
                    tempCode = 0;
                }
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        Object res;
        tempCode = 1;
        if (!(hasNext())) {
            throw new NoSuchElementException();
        } else {
            res = numbers[index];
            return res;
        }
    }

}