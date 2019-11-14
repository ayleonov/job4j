package ru.job4j.exam;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class Connection2Test {
    @Test
    public void when() {
        Connection2 conn = new Connection2("./data/source.txt", "./data/target.txt");
        conn.start();

        List<String[]> list = conn.getList();
        for (String[] arr : list) {

            for (int i = 0; i < 3; i++) {
                System.out.print(arr[i]);
                if (i != 2) {
                    System.out.print(";");
                }
            }
            System.out.println();
        }
        System.out.println();

        Map<String, StringBuilder> a = conn.getMap();
        for (Map.Entry pair : a.entrySet()) {
            System.out.println(String.format("%s %s", pair.getKey(), pair.getValue().toString()));
        }


    }
}

