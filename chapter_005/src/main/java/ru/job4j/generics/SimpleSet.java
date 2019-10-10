package ru.job4j.generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray sa = new SimpleArray(5);

    public SimpleArray getSa() {
        return sa;
    }

    public boolean add(E e) {
        boolean res = false;
        if (!(contains(sa.getArray(), sa.getPosition(), e))) {
            sa.add(e);
            res = true;
        }
        return res;
    }

    public boolean contains(Object[] coll, int position, E e) {
        boolean res = false;
        for (int i = 0; i < position; i++) {
            if (Objects.equals(coll[i], e)) {
                res = true;
                break;
            }
        }

        return res;
    }


    @Override
    public Iterator<E> iterator() {
        return sa.iterator();
    }
}
