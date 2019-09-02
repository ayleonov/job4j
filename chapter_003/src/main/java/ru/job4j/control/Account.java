package ru.job4j.control;

public class Account {

    double value;
    String requisites;

    public Account(double values, String requisites) {
        this.value = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return this.value;
    }


    public String getRequisites() {
        return this.requisites;
    }

    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.value && destination != null) {
            success = true;
            this.value -= amount;
            destination.value += amount;
        }
        return success;
    }

    public String toString() {
        String otvet;
        otvet = "Account{" + "value=" + value + ", requisites='" + requisites + "\\" + "}";
        return otvet;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.requisites.equals(account.requisites);
    }

    public int hashCode() {
        return this.requisites.hashCode();
    }
}