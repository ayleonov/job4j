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
        Node<E> newNode = new Node(child);
        if (findBy(parent) != null) {
            findBy(parent).orElse(null).getChildren().add(newNode);
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

        return new Iterator() {
            int iterpos = -2;
            int sizeChildren;

            @Override
            public boolean hasNext() {
                boolean res = false;

                if (root != null && iterpos == -2) {
                    iterpos = -1;
                    res = true;

                } else {
                    if (iterpos >= -1 && iterpos < sizeChildren) {
                        res = true;
                    }
                }
                return res;
            }

            @Override
            public Object next() {
                sizeChildren = root.getChildren().size();
                Node<E> res = null;
                if (hasNext()) {
                    if (iterpos == -1) {
                        res = root;
                        iterpos = 0;
                    } else {
                        if (iterpos < sizeChildren) {
                            res = root.getChildren().get(iterpos++);
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                } else {
                    throw new NoSuchElementException();
                }
                return res;
            }
        };
    }
}
