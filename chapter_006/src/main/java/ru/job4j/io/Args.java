package ru.job4j.io;

import java.io.File;
import java.util.List;

public class Args {
    private List<String> args;

    public Args(List<String> args) {
        this.args = args;
    }
    public String directory() {
        return "./chapter_005";
    }

    public List<String> exclude() {
        return List.of("*.xml", "*.java");
    }

    public File output() {

        return new File("project.zip");
    }
}
