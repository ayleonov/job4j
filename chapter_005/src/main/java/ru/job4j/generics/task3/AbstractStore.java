package ru.job4j.generics.task3;

import ru.job4j.generics.SimpleArray;

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
        try {
            simpArr.set(findIndexById(id), (E) model);
            res = true;
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        simpArr.remove(findIndexById(id));
        return false;
    }

    @Override
    public E findById(String id) {

        Base object = null;
        int temp = 0;

        for (Object o : simpArr.getArray()) {
            if (((E) o).getId().equals(id)) {
                object = (E) o;
                temp = 1;
                break;
            }
        }
        if (temp == 0) {
            throw new NoSuchElementException();
        }
        return (E) object;
    }

    public Integer findIndexById(String id) {
        int index = 0;
        int temp = 0;
        for (int i = 0; i < simpArr.getArray().length; i++) {
            if (((E) (simpArr.getArray()[i])).getId().equals(id)) {
                index = i;
                temp = 1;
                break;
            }
        }
        if (temp == 0) {
            throw new NoSuchElementException();
        }
        return index;
    }
}
