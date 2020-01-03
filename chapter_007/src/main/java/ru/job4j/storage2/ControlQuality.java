package ru.job4j.storage2;

import ru.job4j.storage2.goods.Food;
import ru.job4j.storage2.storages.Shop;
import ru.job4j.storage2.storages.StoragePlace;
import ru.job4j.storage2.storages.Trash;
import ru.job4j.storage2.storages.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private List<StoragePlace> list;
    private StoragePlace warehouse;
    private StoragePlace shop;
    private StoragePlace trash;

    public List<StoragePlace> getList() {
        return list;
    }

    public void init() {
        list = new ArrayList<>();
        StoragePlace warehouse = new Warehouse();
        list.add(warehouse);
        StoragePlace shop = new Shop();
        list.add(shop);
        StoragePlace trash = new Trash();
        list.add(trash);
    }

    public Food executeStrategy(Food food) {
        Food res = null;
        for (StoragePlace element : list) {
            if (element.accept(food)) {
                element.add(food);
                res = food;
                break;
            }
        }
        return res;
    }
}