package ru.job4j.condition;

public class Max {
    public int max(int first, int second) {

        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {

        return max(max(first, second), third);
    }

    public int max(int first, int second, int third, int fouth) {

        return max(max(first, second), max(third, fouth));
    }
}