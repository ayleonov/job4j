package ru.job4j.map;

import jdk.jfr.StackTrace;

import java.util.HashMap;
import java.util.Map;

public class Research {
    private User u1;
    private User u2;
    private Map<User, Object> map = new HashMap<>();


    public void researching() {
        u1 = new User("Иван", 1, null);
        u2 = new User("Иван", 1, null);
        map.put(u1, 1);
        map.put(u2, 1);
        System.out.println(map);
    }

    @Override
    public String toString() {
        return "Research{" +
                "u1=" + u1 +
                ", u2=" + u2 +
                ", map=" + map +
                '}';
    }
}
