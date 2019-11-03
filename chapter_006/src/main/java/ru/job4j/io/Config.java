package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.path));
            while (br.ready()) {
                String str = br.readLine();
                boolean first = !str.isEmpty();
                boolean second = !str.startsWith("//");
                boolean third = !str.startsWith("##");
                boolean fifth = str.split("=").length == 0;

                if (first && second && third) {
                    if (fifth) {
                        values.put(str.split("=")[0], "");
                    } else {
                        values.put(str.split("=")[0].trim(), str.split("=")[1].trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        String res = "";
        try {
            res = values.get(key);
        } catch (UnsupportedOperationException uoe) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return res;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
