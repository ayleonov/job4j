package ru.job4j.oop;

public class Student {
    private void music(String lyrics) {
        System.out.println("I can sign a song : " + lyrics);
    }

    private void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.song();
        String song = "I believe I can fly";
        petya.music(song);
    }
}
