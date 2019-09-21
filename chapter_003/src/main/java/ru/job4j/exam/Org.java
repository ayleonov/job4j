package ru.job4j.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Org {
    private List<String> namestring = new ArrayList<>();

    public List<String> getNamestring() {
        return namestring;
    }

    public Org(List<String> namestring) {
        this.namestring = namestring;
    }

    public void sorting(int directionSorting) {
        namestring.sort(directionSorting == 0 ? directSorting : reverseSorting);
    }

    Comparator directSorting = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            String str1 = (String) o1;
            String str2 = (String) o2;
            return str1.compareTo(str2);
        }
    };
    Comparator reverseSorting = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            String str1 = (String) o1;
            String str2 = (String) o2;

            return str2.compareTo(str1);
        }
    };
}

