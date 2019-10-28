package ru.job4j.io;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Search {
    List<File> list = new ArrayList<File>();

    public List<File> findFiles(String parent, List<String> exts) {
        File file = new File(parent);
        File[] allFiles = file.listFiles();
        for (File el : allFiles) {
            if (!el.isDirectory()) {
                String name = el.getName();
                String extEl = el.getName().split("\\.")[1];
                if (exts.contains(extEl)) {
                    list.add(new File(el.getPath()));
                }
            } else {
                findFiles(el.getPath(), exts);
            }
        }
        return list;
    }
}
