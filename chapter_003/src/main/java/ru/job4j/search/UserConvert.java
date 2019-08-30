package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;

public class UserConvert {
    private static final Random RN = new Random();
    private List<Integer> listIds;

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        listIds = new ArrayList();
        for (User element : list) {
            int id = getId();

            map.put(id, element);
            listIds.add(id);
        }
        return map;
    }

    public int getId() {
        return (int) (System.currentTimeMillis() + RN.nextInt());
    }

    public List<Integer> getListids() {
        return listIds;
    }
}


