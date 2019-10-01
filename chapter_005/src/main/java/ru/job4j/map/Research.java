package ru.job4j.map;

import jdk.jfr.StackTrace;

import java.util.HashMap;
import java.util.Map;

public class Research {
    private User u1;
    private User u2;
    private HashMap<User, Object> map = new HashMap<>();

    public HashMap<User, Object> getMap() {
        return map;
    }

    public void researching() {
        u1 = new User("Иван", 1, null);
        u2 = new User("Иван", 1, null);

        map.put(u1, 17);
        map.put(u2, 19);
        System.out.println(map);
    }

}
