package ru.job4j.oop;

public class Student {
    private void music() {
        System.out.println("Tra Tra Tra");
    }

    private void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}
