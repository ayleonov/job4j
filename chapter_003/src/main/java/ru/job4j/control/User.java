package ru.job4j.control;

public class User implements Comparable<User> {
    String name;
    String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public int compareTo(User user) {

        return this.getName().compareTo(user.getName());
    }
}