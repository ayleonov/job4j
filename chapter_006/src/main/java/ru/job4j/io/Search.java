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
                    if (checkExtention(file, exts)) {
                        System.out.println(file.getName());
                        list.add(file);

                    }
                }
            }
        }
        return list;
    }

    public boolean checkExtention(File file, List<String> exts) {
        boolean res = false;
        String extFile = file.getName().split("\\.")[1];
        if (exts.contains(extFile)) {
            res = true;
        }
        return res;
    }
}
