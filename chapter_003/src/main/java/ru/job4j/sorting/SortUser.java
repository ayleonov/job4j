package ru.job4j.sorting;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> list) {

        return new TreeSet(list);
    }

    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new LengthComparator());
        return list;
    }


    public List<User> sortByAllFields(List<User> list) {
        //Comparator<User> myComparator = new LexicographComparator().thenComparing(new AgeComparator());
        //Collections.sort(list, myComparator);
        list.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));

        return list;
    }
}



