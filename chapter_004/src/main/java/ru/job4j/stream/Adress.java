package ru.job4j.stream;

public class Adress {
    private String city;
    private String street;
    private int numberHouse;
    private int numberApartment;

    public Adress(String city, String street, int numberHouse, int numberApartment) {
        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
        this.numberApartment = numberApartment;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumberHouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }

    public void setNumberAppartment(int numberApartment) {
        this.numberApartment = numberApartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getNumberHouse() {
        return numberHouse;
    }

    public int getNumberAppartment() {
        return numberApartment;
    }
}
