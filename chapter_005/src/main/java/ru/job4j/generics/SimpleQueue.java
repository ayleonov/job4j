package ru.job4j.generics;

public class SimpleQueue<T> {
    SimpleStack firstStack = new SimpleStack();
    SimpleStack secondStack = new SimpleStack();
    int size = 0;

    public T poll() {

        return (T) secondStack.poll();
    }

    public void push(T value) {
        for (int i = 0; i < size; i++) {
            firstStack.push(secondStack.poll());
        }

        firstStack.push(value);
        size++;

        for (int i = 0; i < size; i++) {
            secondStack.push(firstStack.poll());
        }
    }
}

