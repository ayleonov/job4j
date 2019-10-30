package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(E value) {
        root = new Node(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean res = false;
        if (parent != null && child != null) {
            Node<E> newNode = new Node(child);
            findBy(parent).get().getChildren().add(newNode);
            res = true;
        }
        return res;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public Iterator iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);

            Node<E> el = data.peek();
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }

        return new Iterator() {

            @Override
            public boolean hasNext() {
                return data.size() > 0;
            }

            @Override
            public Object next() {
                Node<E> res;
                if (hasNext()) {
                    res = data.poll();
                }else {
                 throw new NoSuchElementException();
                }
                return res;
            }
        };
    }
}
