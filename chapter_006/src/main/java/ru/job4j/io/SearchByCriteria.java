package ru.job4j.io;

import ru.job4j.io.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SearchByCriteria {
    String parent;
    Queue data = new LinkedList();
    List<String> templates = new ArrayList();

    public SearchByCriteria(String parent) {
        this.parent = parent;
    }

    public void start() {


    }

}
