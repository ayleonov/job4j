package ru.job4j.generics;

public class SimpleArrayList<E> {
    private Node<E> first;
    private int size;

    public void add(E data) {
        Node<E> newlink = new Node(data);
        newlink.next = this.first;
        this.first = newlink;
        this.size++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public E delete() {
        Node<E> deleted = this.first;
        this.first = this.first.next;
        this.size--;
        return deleted.data;
    }

    public int getSize() {
        return size;
    }

    public Node<E> getFirst() {
        return first;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
