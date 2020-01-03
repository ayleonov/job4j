package ru.job4j.storage2.storages;

import ru.job4j.storage2.goods.Food;

public interface StoragePlace  {

    boolean accept(Food food);
    Food add(Food food);

}