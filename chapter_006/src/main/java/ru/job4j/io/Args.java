package ru.job4j.io;

import java.io.File;
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
        args[0] = "./chapter_006";
    }

    public void exclude() {
        args[1] = "*.java";
    }

    public void output() {
        args[2] = "project.zip";
    }
}
