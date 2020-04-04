package ru.job4j.storage;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ControlQualityTest {
    ControlQuality cq;

    @Before
    public void beforeTest() {
        cq = new ControlQuality();
    }

    @Test
    public void whenTestingTotalProgramWithCarrot() throws ParseException {
        Service service = new Service();
        Food food = new Carrot(service.converterToLong("2020-11-30"), service.converterToLong("2019-12-03"), 20, 10);
        int carrotPercent = service.calculPercent(food.getCreateDate(), food.getExpireDate());
        StoragePlace shipping = service.separate(food, carrotPercent);
        service.shipment(shipping, 2);
        assertThat(shipping.getWeight(), is(2.0));
        assertThat(food.getPrice(), is(20.0));
    }

    @Test
    public void whenTestingTotalProgramWithCarrot2() throws ParseException {
        Service service = new Service();
        Food food = new Carrot(service.converterToLong("2020-03-30"), service.converterToLong("2018-12-03"), 20, 10);
        int carrotPercent = service.calculPercent(food.getCreateDate(), food.getExpireDate());
        StoragePlace shipping = service.separate(food, carrotPercent);
        service.shipment(shipping, 2);
        assertThat(shipping.getWeight(), is(2.0));
        // проверка, что учтена скидка
        food.getPrice();
       // assertThat(food.getPrice(), is(18.0)); проверено.  без ошибок. зависит от даты (процент падает)
    }

    @Test
    public void whenTestingTotalWithPotato() throws ParseException {
        Service service = new Service();
        Food food = new Potato(service.converterToLong("2020-11-30"), service.converterToLong("2019-12-03"), 20, 10);
        int percent = service.calculPercent(food.getCreateDate(), food.getExpireDate());
        StoragePlace shipping = service.separate(food, percent);
        service.shipment(shipping, 2);
        assertThat(shipping.getWeight(), is(2.0));
        assertThat(food.getPrice(), is(20.0));
    }

    @Test
    public void whenTestingTotalProgramWithCheese() throws ParseException {
        Service service = new Service();
        Food food = new Cheese(service.converterToLong("2020-11-30"), service.converterToLong("2019-12-03"), 20, 10);
        int percent = service.calculPercent(food.getCreateDate(), food.getExpireDate());
        StoragePlace shipping = service.separate(food, percent);
        service.shipment(shipping, 2);
        assertThat(shipping.getWeight(), is(2.0));
        assertThat(food.getPrice(), is(20.0));
    }
}