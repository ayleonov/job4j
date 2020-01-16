package ru.job4j.parking;

public abstract class Car {
    private String name;
    private int numberPlaces;

    public Car(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }

    public int getNumberPlaces() {
        return numberPlaces;
    }
}
