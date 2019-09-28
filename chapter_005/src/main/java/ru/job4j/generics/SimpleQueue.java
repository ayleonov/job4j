package ru.job4j.generics;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleQueue<T> implements Iterable<T> {
 SimpleStack simpstack = new SimpleStack();
    private int modCount = 0;

    public T poll() {
        simpstack.dcl.delete();
        return null;
    }

    public void push(T value) {
        simpstack.dcl.add(value);
    }

    public T getLast(){
        return (T)simpstack.get(simpstack.dcl.getSize() - 1);
    }
    public T getElementsFromLast(int index) {
        int indexLast = simpstack.dcl.getSize() - 1 - index;
        return (T)simpstack.get(indexLast);
    }



    @Override
    public Iterator iterator() {
        int expectedmodCount = modCount;
        int numberelements = simpstack.dcl.countelements();
        return new Iterator() {
            int iterposition = 0;
            //   DinamicContainerLinked.Node<T> curr = first;

            @Override
            public boolean hasNext() {

                return iterposition < numberelements;
            }

            @Override
            public Object next() {
                Object res = null;
                T resD;
                if (expectedmodCount != modCount) {
                    throw new ConcurrentModificationException();
                } else if (!(hasNext())) {
                    throw new NoSuchElementException();
                } else {
                    res = getElementsFromLast(iterposition);
                    }
                    iterposition++;

                    return res;
                }
        };
    }
}

