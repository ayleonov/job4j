package ru.job4j.iterator;

import java.util.Iterator;


public class Iterator2dimension<Integer> implements Iterator {
    private int[][] values;
    private int[] valuesArray = new int[4];
    private int index = 0;

    public Iterator2dimension(int[][] values) {
        this.values = values;
        foreach();
    }

    @Override

    public boolean hasNext() {
        return valuesArray.length > index;
    }

    @Override
    public Object next() {
        return valuesArray[index++];
    }

    public int[] foreach() {
        int count = -1;
        for (int[] value : values) {
            for (int element : value) {
                valuesArray[count + 1] = element;
                count++;
            }
        }
        return valuesArray;
    }
}
