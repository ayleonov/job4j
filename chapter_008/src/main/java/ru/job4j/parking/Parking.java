package ru.job4j.parking;

public class Parking implements CarsOperations {
    // SIZE - количество машино-мест при проектировании.
    private final int SIZE = 5;
    private Car[] places = new Car[SIZE];

    @Override
    public int accept(Car car) {
        int numberPlaces = car.getNumberPlaces();
        int temp = 0;
        int startPlace = -1;

        for (int i = 0; i < places.length; i++) {

            if (places[i] == null) {
                if (temp == 0) {
                    startPlace = i;
                }
                temp++;

                if (temp == numberPlaces) {
                    break;
                } else {
                    if (i==places.length-1){
                        startPlace = -1;
                    }
                    continue;
                }
            } else {
                temp = 0;
                startPlace = -1;
                continue;
            }

        }
        if (startPlace == -1) {
            System.out.println("нет мест");
        }
        return startPlace;
    }

    @Override
    public Car add(Car car, int firstPlace) {
        for (int i = 0; i < car.getNumberPlaces(); i++) {
            places[i + firstPlace] = car;
        }
        return car;
    }

    @Override
    public boolean remove(Car car) {
        boolean ifDeleted = false;
        boolean ifCarWasEarlier = false;
        for (int i = 0; i < places.length; i++) {
             if (places[i] !=null) {
            if (places[i].equals(car)) {
                places[i] = null;
                ifCarWasEarlier = true;
            } else {
                if (ifCarWasEarlier) {
                    ifDeleted = true;
                    break;
                }
            }
        }
        }
        if (ifDeleted = false) {
            System.out.println("Данная машина на парковке не значится");
        }
        return ifDeleted;
    }


    public Car[] getPlaces() {
        return places;
    }

    public void showScheme() {
        for (int i = 0; i < places.length; i++) {
            System.out.println(places[i]);
        }
    }

}
