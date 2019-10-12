package ru.job4j.generics;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    SimpleStack firstStack = new SimpleStack();
    SimpleStack secondStack = new SimpleStack();

    public void convert() {
        for (int i = 0; i < firstStack.dcl.getSize(); i++) {
            secondStack.push(firstStack.dcl.get(i));
        }
    }

    public void queue(T value) {
        firstStack.push(value);
    }

    public T poll() {
        convert();
        return (T) secondStack.poll();

    }

    public void push(T value) {

        firstStack.push(value);
    }
}

