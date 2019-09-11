package ru.job4j.stream;

public class Student {
    private final int score;
    private final String name;
    private final String surname;

    public Student(int score, String name, String surname) {
        this.score = score;
        this.name = name;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
