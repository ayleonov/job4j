package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        while (amount > 0) {
            year++;
            amount = (int) (amount + (amount * percent / 100) - 12 * monthly);
        }
        return year;
    }
}