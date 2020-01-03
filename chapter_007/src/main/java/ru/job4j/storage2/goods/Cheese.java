package ru.job4j.storage2.goods;


public class Cheese extends Food {

    private String name = "cheese";
    private String expireDate;
    private String createDate;
    private double price;
    private double discount;

    public Cheese(String createDate, String expireDate, double price, double discount) {
        super(createDate, expireDate, price, discount);
    }
}