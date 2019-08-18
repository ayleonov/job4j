package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class TrackerSingleFourth {


    private final Item[] items = new Item[100];
    private static final Random RN = new Random();
    private int position = 0;

    public TrackerSingleFourth() {

    }

    public static TrackerSingleFourth getInstance() {

        return Holder.INSTANCE;
    }

    private final static class Holder {
        private static final TrackerSingleFourth INSTANCE = new TrackerSingleFourth();
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {

        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                items[index] = item;
                items[index].setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < position; index++) {
            if ((items[index] != null) && (items[index].getId().equals(id)) && (index < position)) {
                System.arraycopy(items, index + 1, items, index, position - index);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }


    public Item[] findAll() {

        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        int count = 0;
        Item[] temp = new Item[this.position];
        for (int index = 0; index < position; index++) {
            if ((items[index] != null) && items[index].getName().equals(key)) {
                temp[count++] = items[index];
            }
        }
        return Arrays.copyOf(temp, count);
    }

    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && items[index].getId().equals(id)) {
                result = items[index];
                break;
            }
        }
        return result;
    }


    public int findIndexThroughId(String id) {
        int result = -1;
        for (int index = 0; index < position; index++) {
            if ((items[index] != null) && items[index].getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }
}