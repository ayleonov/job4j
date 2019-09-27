package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private int position = 0;
    private final Object[] array;

    public Object[] getArray() {
        return array;
    }

    public int getPosition() {
        return position;
    }

    public SimpleArray(final int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        if (position + 1 > array.length) {
            throw new NoSuchElementException();
        } else {
            this.array[position++] = model;
        }
    }

    public boolean set(int index, T model) {
        boolean res;
        if (position > index) {
            res = true;
            this.array[index] = model;
        } else {
            res = false;
        }
        return res;
    }

    public boolean remove(int index) {
        boolean res;
        if (position > index) {
            res = true;
            System.arraycopy(array, index + 1, array, index, array.length - 2);
            position--;
        } else {
            res = false;
        }
        return res;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int iterposition = 0;

            @Override
            public boolean hasNext() {
                boolean res = false;
                if (position > iterposition) {
                    res = true;

                } else {
                    res = false;
                }
                return res;
            }

            @Override
            public T next() {
                T res;
                if (!(hasNext())) {
                    throw new NoSuchElementException();
                } else {
                    res = (T) array[iterposition++];
                }
                return res;
            }
        };
    }
}
