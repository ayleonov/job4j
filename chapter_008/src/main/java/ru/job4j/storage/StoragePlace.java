package ru.job4j.storage;

public class StoragePlace implements Strategy {
    private double weight;

    @Override
    public void moving(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}