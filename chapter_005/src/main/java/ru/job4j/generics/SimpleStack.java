package ru.job4j.generics;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleStack<E> implements Iterable<E> {
    DinamicContainerLinked dcl = new DinamicContainerLinked();

    public void push(E value) {
        dcl.add(value);
    }

    public E poll() {
        return (E) dcl.delete();
    }

    public E get(int index) {
        return (E) dcl.get(index);
    }

    @Override
    public Iterator iterator() {
        return dcl.iterator();
    }
}

