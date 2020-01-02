package ru.job4j.storage;

public class Carrot extends Food {
    private String name = "carrot";
    private long expireDate;
    private long createDate;
    private int price;
    private int discount;

    public Carrot(long expireDate, long createDate, int price, int discount) {
        super(expireDate, createDate, price, discount);
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }
}
