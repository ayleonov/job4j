package ru.job4j.parking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ParkingTest {
    private CarsOperations parking;
    private Car car1;
    private Car car2;
    Car[] places;
    Car[] places2;

    @Before
    public void beforeTest() {
        parking = new Parking();
        car1 = new PassengerCar(1);
        car2 = new Truck(3);
        places = new Car[]{car1, null, null, null, car1};
        places2 = new Car[]{car1, null, car1, null, null};
    }


    public void showScheme() {
        Car[] res = ((Parking) parking).getPlaces();
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    @Test
    public void whenTestingAdd() {
        parking.add(car1, 0);
        parking.add(car1, 4);
        Car[] res = ((Parking) parking).getPlaces();
        assertThat(res, is(places));
    }


    @Test
    public void whenTestingAccept() {
        parking.add(car1, 0);
        parking.add(car1, 4);
        showScheme();
        int res = parking.accept(car2);
        assertThat(res, is(1));
    }

    @Test
    public void whenTestingAccept2() {
        parking.add(car1, 0);
        parking.add(car1, 2);
        int res2 = parking.accept(car2);
        assertThat(res2, is(-1));
    }

    @Test
    public void whenTestingShowScheme() {
        parking.add(car1, 0);
        parking.add(car1, 4);
        //визуально должны наблюдаться занятые клетки 0 4  и незанятые 123
        ((Parking) parking).showScheme();
    }

    @Test
    public void whenTestRemoveExistingCar() {
        parking.add(car1, 0);
        Car car3 = new PassengerCar(1);
        parking.add(car3, 3);
        parking.remove(car3);
        Car[] places3 = {car1, null, null, null, null};
        Car[] res = ((Parking) parking).getPlaces();
        assertThat(res, is(places3));
    }

    @Test
    public void whenTestTryRemoveIfNoThisCar() {
        parking.add(car1, 0);
        Car car3 = new PassengerCar(1);
        boolean res = parking.remove(car3);
        assertFalse(res);
    }
}

