package ru.job4j.generics;


public class Proba5 {
    private int position = 0;
    private String[] array = new String[8];

    public int getPosition() {
        return position;
    }

    public String[] getArray() {
        return array;
    }

    public void add(String value) {
        array[position++] = value;
    }

    public void delete(int i) {

        System.arraycopy(array, i + 1, array, i, array.length - 1 - i);
        position--;
    }
}
