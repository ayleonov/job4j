package ru.job4j.storage2.storages;


import ru.job4j.storage2.Service;
import ru.job4j.storage2.goods.Food;

public class Warehouse implements StoragePlace {
    private Food food;

    @Override
    public boolean accept(Food food) {
        boolean res = false;

        if (Service.calculPercent(food.getCreateDate(), food.getExpireDate()) < 25) {
            res = true;
        }
        return res;
    }

    @Override
    public Food add(Food food) {
        return food;
    }
}
