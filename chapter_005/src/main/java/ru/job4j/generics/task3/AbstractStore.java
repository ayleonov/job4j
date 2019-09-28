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

            res = simpArr.set(findIndexById(id), (E) model);
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res = false;
        try {
            int foundIndex = findIndexById(id);
            int found = foundIndex;
            res = simpArr.remove(findIndexById(id));
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return res;
    }

    @Override
    public E findById(String id) {

        Base object = null;

        try {
            for (Object o : simpArr.getArray()) {
                if (((E) o).getId().equals(id)) {
                    object = (E) o;
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return (E) object;
    }

    public Integer findIndexById(String id) {
        int index = -1;
        try {
            for (int i = 0; i < simpArr.getPosition(); i++) {
                E element = (E) (simpArr.getArray()[i]);
                String elementId = element.getId();
                if (elementId.equals(id)) {
                    index = i;
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            e.getMessage();
        }

        return index;
    }
}
