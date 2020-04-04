package ru.job4j.storage2.goods;


public class Carrot extends Food {
    private String name = "carrot";
    private String expireDate;
    private String createDate;
    private double price;
    private double discount;

    public Carrot(String createDate, String expireDate, double price, double discount) {
        super(createDate, expireDate, price, discount);
    }


}
