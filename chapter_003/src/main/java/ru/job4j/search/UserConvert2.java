package ru.job4j.search;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class UserConvert2 {
    private static final Random RN = new Random();

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User element : list) {
            map.put(getId(), element);
        }
        return map;
    }

    public int getId() {
        return (int) (System.currentTimeMillis() + RN.nextInt());
    }
}


