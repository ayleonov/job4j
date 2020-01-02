package ru.job4j.storage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlQuality {

    public static void main(String[] args) throws ParseException {
        Service service = new Service();
        Food food = new Carrot(service.converterToLong("2020-11-30"),service.converterToLong("2019-12-03"),20,10);
        int carrotPercent = service.calculPercent(food.getCreateDate(), food.getExpireDate());
        StoragePlace shipping = service.separate(food, carrotPercent);
        service.shipment(shipping, 2);
        System.out.println(shipping.getWeight());
        //System.out.println(shipping.getWeight());

    }
}
