package ru.job4j.generics;

import org.junit.Test;


//package ru.job4j.generics;

//        import org.junit.Test;

public class Proba5Test {
    Proba5 pr;

    @Test
    public void whenAddElementsWithNullAndDeleteFirstElement() {
        pr = new Proba5();
        pr.add("0");
        pr.add("1");
        pr.add("2");
        pr.add(null);
        pr.add("3");
        pr.add("4");
        print();
        System.out.println(String.format("Position(перед удалением): %d", pr.getPosition()));
        pr.delete(1);
        print();
        System.out.println(String.format("Position(после удаления): %d", pr.getPosition()));
    }

    public void print() {
        System.out.println("---------- Начало печати-------");
        int realnumber = 0;
        for (Object obj : pr.getArray()) {
            System.out.println(obj);
            if (obj != null) {
                realnumber++;
            }
        }
        System.out.println("---------- Завершение печати-------");
        System.out.println(String.format("Количество НЕНУЛЕВЫХ элементов: %d", realnumber));
    }
}