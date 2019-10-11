package ru.job4j.generics;

public class FindCircles<T> {

    public boolean hasCircles(Node first) {
        if (first == null) {
            return false;
        }
        Node turtle = first;
        Node hare = first;
        while (hare.next != null && hare.next.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                return true;
            }
        }
        return false;
    }

    static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

}
