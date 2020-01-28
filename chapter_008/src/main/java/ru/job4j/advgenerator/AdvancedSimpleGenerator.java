package ru.job4j.advgenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvancedSimpleGenerator implements ITemplate {
    Map<String, String> map = new HashMap();

    public Map<String, String> getMap() {
        return map;
    }

    @Override
    public String generate(String template, Map<String, String> map) {
        Map<Integer, Map.Entry> mapSelect = new HashMap<>();
        int n = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            mapSelect.put(n++, pair);
        }
        int selection = (int)(mapSelect.size()*Math.random());
        Map.Entry pairSelection = mapSelect.get(selection);
        String name = (String)pairSelection.getKey();
        String subject = (String)pairSelection.getKey();
        return template;
    }
}
