package ru.job4j.parking;

public class Controller {

    public static void main(String[] args) {
        Parking parking = new Parking();
        int lengParking = parking.getPlaces().length;
        Car car1 = new PassengerCar(1);
        int startCell = parking.accept(car1);
        parking.add(car1, startCell);
        System.out.println(parking.getPlaces()[startCell].equals(car1));

    }
}
