package ru.job4j.generics;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicContainerLinked<E> implements Iterable<E> {
    private Node<E> node;
    private int modCount = 0;
    private Node<E> first;
    private int size;

    public void add(E value) {
        Node<E> newLink = new Node(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public E delete() {
        Node<E> deleted = this.first;
        this.first = this.first.next;
        this.size--;
        return deleted.data;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int countelements() {
        int numberelements = 0;
        for (int i = 0; i < size; i++) {
            if (get(i) != null) {
                numberelements++;
            }
        }
        return numberelements;
    }

    @Override
    public Iterator iterator() {
        int expectedmodCount = modCount;
        int numberelements = this.countelements();

        return new Iterator() {
            int iterposition = 0;
            Node<E> curr = first;

            @Override
            public boolean hasNext() {

                return iterposition < numberelements;
            }

            @Override
            public Object next() {
                Node<E> res = null;
                E resD;
                if (expectedmodCount != modCount) {
                    throw new ConcurrentModificationException();
                } else if (!(hasNext())) {
                    throw new NoSuchElementException();
                } else {
                    if (iterposition == 0) {
                        res = curr;
                        resD = res.data;
                    } else {
                        curr = curr.next;
                        res = curr;
                        resD = res.data;
                    }
                    iterposition++;
                    return res.data;
                }
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}

