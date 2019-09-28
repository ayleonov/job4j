package ru.job4j.generics;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicContainer<E> implements Iterable<E> {
    private Object[] container;
    private int position = 0;
    private static final int STARTSIZE = 10;
    private int size = STARTSIZE;
    private int modCount = 0;

    public DinamicContainer() {
        this.container = new Object[size];
    }

    public Object[] getContainer() {
        return container;
    }

    public void add(E value) {
        if (position + 1 > size) {
            basearrayIncrese();
        }
        container[position++] = value;
        modCount++;
    }

    public void basearrayIncrese() {
        size = (int) (size * 1.5);

        this.container = Arrays.copyOf(container, size);

    }


    public E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator iterator() {
        int expectedmodCount = modCount;

        return new Iterator() {
            int iterposition = 0;

            @Override
            public boolean hasNext() {

                return iterposition < position;
            }

            @Override
            public Object next() {
                if (expectedmodCount != modCount) {
                    throw new ConcurrentModificationException();
                } else if (!(hasNext())) {
                    throw new NoSuchElementException();
                } else {
                    return container[iterposition++];
                }
            }
        };
    }
}

