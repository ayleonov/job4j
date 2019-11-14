package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Args {
    private String[] args;
    private String d = args[0];
    private String e = args[1];
    private String o = args[2];

    public Args(String[] args) {
        this.args = args;
    }
    public void directory() {
        String dir = "chapter_006";
        File file = new File(dir);
        if (file.exists() && file.isDirectory()) {
            args[0] = dir;
        }

    }

    public void exclude() {
        List<String> exts = List.of("java","txt","doc", "log");
        String excl = "*.java";

        if (exts.contains(excl.split("\\."))) {
            args[1] = "*.java";
        }
    }

    public void output() throws IOException {
        String target = "project.zip";
        File file = new File(target);
        file.createNewFile();
        args[2] = "project.zip";
    }
}
