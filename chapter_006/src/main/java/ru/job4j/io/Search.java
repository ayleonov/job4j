package ru.job4j.io;


import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {
    List<File> list = new ArrayList();
    Queue<File> data = new LinkedList<>();

    public List<File> findFiles(String parent, List<String> exts) {
        File filePar = new File(parent);
        data.offer(filePar);
        while (!data.isEmpty()) {
            File el = data.poll();
            for (File file : el.listFiles()) {
                if (file.isDirectory()) {
                    data.offer(file);
                } else {
                    String extFile = file.getName().split("\\.")[1];
                    if (exts.contains(extFile)) {
                        list.add(file);
                    }
                }
            }
        }
        return list;
    }

    public List<File> findFiles2(String parent, List<String> exts) {
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
                findFiles2(el.getPath(), exts);
            }
        }
        return list;
    }
}
