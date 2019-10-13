package ru.job4j.generics.task3;

import ru.job4j.generics.SimpleArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractStore<E extends Base> implements Store<E> {
    private SimpleArray<E> simpArr = new SimpleArray<>(100);

    public SimpleArray<E> getSimpArr() {
        return simpArr;
    }

    @Override
    public void add(Base model) {
        simpArr.add((E) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean res = false;
        int index = findIndexById(id);
        if (index != -1) {
            simpArr.set(index, (E) model);
            res = true;
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res = false;
        int index = findIndexById(id);
        if (index != -1) {
            simpArr.remove(index);
            res = true;
        }

        return res;
    }

    @Override
    public E findById(String id) {
        E res = null;

        int index = findIndexById(id);

        if (index != -1) {
            res = (E) simpArr.getArray()[index];
        }
        return (E) res;
    }

    public Integer findIndexById(String id) {
        int index = -1;
        int count = 0;
        Iterator it = simpArr.iterator();
          while(count<simpArr.getPosition()){
            if (((E)(it.next())).getId().equals(id)) {
                index = count;
                break;
            }
          count++;
        }

        return index;
    }
}