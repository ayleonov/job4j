package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово: " + eng;
    }

    public static void main(String[] args) {
        DummyDic dummydic = new DummyDic();
        String word = dummydic.engToRus("cat");
        System.out.println(word);
    }
}
