package ru.job4j.storage2.goods;

public class Potato  extends Food {
    private String name = "potato";
    private String expireDate;
    private String createDate;
    private double price;
    private double discount;

    public Potato(String createDate, String expireDate, double price, double discount) {
        super(createDate, expireDate, price, discount);
    }
}