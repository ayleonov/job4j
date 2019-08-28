package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    private final List<Item> items = new ArrayList<>();

    private static final Random RN = new Random();
    private int position = 0;

    public Item add(Item item) {

        item.setId(this.generateId());
        items.add(item);

        return item;
    }

    private String generateId() {

        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                items.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if ((items.get(i) != null) && (items.get(i).getId().equals(id))) {
                items.remove(items.get(i));
                result = true;
                break;
            }
        }
        return result;
    }


    public List<Item> findAll() {
        List<Item> itemTemp = new ArrayList<>(items.size());
        for (int i = 0; i < items.size(); i++) {
            itemTemp.add(items.get(i));
        }
        return itemTemp;
    }

    public List<Item> findByName(String key) {
        int count = 0;
        List<Item> found = new ArrayList<>();
        for (Item itemTemp : items) {
            if ((itemTemp != null) && itemTemp.getName().equals(key)) {
                found.add(itemTemp);
            }
        }
        return found;
    }

    public Item findById(String id) {
        Item result = null;

        for (Item itemTemp : items) {
            if (itemTemp != null && itemTemp.getId().equals(id)) {
                result = itemTemp;
                break;
            }
        }
        return result;
    }


    public int findIndexThroughId(String id) {
        int result = -1;

        for (Item itemTemp : items) {
            if (itemTemp != null && itemTemp.getId().equals(id)) {
                result = items.indexOf(itemTemp);
                break;
            }
        }

        return result;
    }
}