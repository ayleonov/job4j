package ru.job4j.storage2.storages;


import ru.job4j.storage2.Service;
import ru.job4j.storage2.goods.Food;

public class Shop implements StoragePlace {
    private Food food;

    @Override
    public boolean accept(Food food) {
        boolean res = false;
        int percent = Service.calculPercent(food.getCreateDate(), food.getExpireDate());
        if (percent >= 25 && percent <= 75) {
            res = true;
        } else if (percent > 75 && percent <= 100) {
            food.setPrice((1- (food.getDiscount() / 100)) * food.getPrice());
            res = true;
        }
        return res;
    }

    @Override
    public Food add(Food food) {
        return food;
    }
}
