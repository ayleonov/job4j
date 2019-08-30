package ru.job4j.sorting;

import java.util.Comparator;

public class LexicographComparator implements Comparator<User> {

    public int compare(User a, User b) {
        return a.getName().compareTo(b.getName());
    }


}