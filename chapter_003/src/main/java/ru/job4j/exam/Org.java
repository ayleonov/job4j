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
            int temp = 0;
            int res = -1;
            String str1 = (String) o1;
            String str2 = (String) o2;
            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();
            int minlength = char1.length < char2.length ? char1.length : char2.length;
            for (int i = 0; i < minlength; i++) {
                if (char2[i] < char1[i]) {
                    res = 1;
                    temp = 1;
                    break;
                } else {
                    if (char1[i] == '\\') {
                        continue;
                    }
                    if (char2[i] == char1[i]) {
                        continue;
                    } else {
                        if (char2[i] > char1[i]) {
                            res = -1;
                            temp = 1;
                            break;
                        }
                    }
                }
            }
            if (temp != 1) {
                if (char1.length > char2.length) {
                    res = 1;
                } else {
                    if (char1.length == char2.length) {
                        res = 0;
                    } else {
                        res = -1;
                    }
                }
            }
            return res;
        }
    };
    Comparator reverseSorting = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            int temp = 0;
            int res = -1;
            String str1 = (String) o1;
            String str2 = (String) o2;
            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();
            int minlength = char1.length < char2.length ? char1.length : char2.length;
            for (int i = 0; i < minlength; i++) {
                if (char2[i] > char1[i]) {
                    res = 1;
                    temp = 1;
                    break;
                } else {
                    if (char1[i] == '\\') {
                        continue;
                    }
                    if (char2[i] == char1[i]) {
                        continue;
                    } else {
                        if (char2[i] < char1[i]) {
                            res = -1;
                            temp = 1;
                            break;
                        }
                    }
                }
            }
            if (temp != 1) {
                if (char1.length > char2.length) {
                    res = 1;
                } else {
                    if (char1.length == char2.length) {
                        res = 0;
                    } else {
                        res = -1;
                    }
                }
            }
            return res;
        }
    };
}
