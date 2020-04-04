package ru.job4j.storage2.goods;


import ru.job4j.storage2.Service;

import java.text.ParseException;

public abstract class Food {
    private String name;
    private String expireDate;
    private String createDate;
    private double price;
    private double discount;

    public Food(String createDate, String expireDate, double price, double discount) {
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public long getExpireDate() {
        long res = 0;
        try {
            res = Service.converterToLong(expireDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    public long getCreateDate() {

        long res = 0;
        try {
            res = Service.converterToLong(createDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
