package ru.job4j.array;

public class Check {
    public boolean mono(boolean data[]) {
        boolean temp = data[0];
        for (boolean sign : data) {
            if (sign != temp) {
                return false;
            }
        }
        return true;
    }
}
