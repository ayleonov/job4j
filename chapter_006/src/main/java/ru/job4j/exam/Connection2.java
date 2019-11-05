package ru.job4j.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Connection2 {
    private String source = "./source.txt";
    private String target = "./target.txt";
    private List<String[]> list = new ArrayList<>();
    private Map<String, StringBuilder> map = new HashMap<>();
    int numberString = 0;

    public Connection2(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public void start() {
    readStrings();
    comparisionStrings();
    }


    public void readStrings() {
        try (
                BufferedReader br = new BufferedReader(new FileReader(source))) {

            while (br.ready()) {
                String str = br.readLine();
                if (!str.isEmpty() && (!str.startsWith("//")) && (!str.startsWith("//"))) {
                    list.add(stringToArray(str));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] stringToArray(String str) {
        String[] res = str.split(";");
        return res;
    }

    public void comparisionStrings() {


            for (String[] el : this.list) {
                for (int i = 0; i < 3; i++) {

                if (!map.containsKey(el[i])) {
                    map.put(el[i], new StringBuilder().append(numberString));
                }   else {
                    map.put(el[i], map.get(el[i]).append(";").append(numberString));
                }
            }
                numberString++;
        }

    }

    public Map<String, StringBuilder> getMap() {
        return map;
    }

    public List<String[]> getList() {
        return list;
    }
}



