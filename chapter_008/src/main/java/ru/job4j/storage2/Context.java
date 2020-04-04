package ru.job4j.storage2;


import ru.job4j.storage2.goods.Food;
import ru.job4j.storage2.storages.StoragePlace;

public class Context {
    StoragePlace strategy;

    public Context(StoragePlace strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Food food) {
        strategy.accept(food);
    }
}
