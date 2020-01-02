package ru.job4j.storage;

public abstract class Food {
    private String name;
    private long expireDate;
    private long createDate;
    private double price;
    private double discount;

    public Food(long expireDate, long createDate, double price, double discount) {
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public long getExpireDate() {
        return expireDate;
    }

    public long getCreateDate() {
        return createDate;
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
