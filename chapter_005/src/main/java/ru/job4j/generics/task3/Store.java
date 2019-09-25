package ru.job4j.generics.task3;

import ru.job4j.generics.task3.Base;

public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
