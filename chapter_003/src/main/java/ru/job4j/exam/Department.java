package ru.job4j.exam;

import java.util.Arrays;
import java.util.Comparator;

public class Department {
    public String[] sorting(String[] departments) {
        Arrays.stream(departments).sorted().forEach(System.out::println);
        return departments;
    }

    public String[] sortingReverse(String[] departments) {
        Comparator reverseComparator1 = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare(((String) o2).charAt(1), ((String) o1).charAt(1));
            }
        };
        Comparator reverseComparator2 = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (((String) o1).length() >= 6 && ((String) o1).length() >= 6)
                    return Integer.compare(((String) o2).charAt(5), ((String) o1).charAt(5));
                else
                    return 0;
            }
        };

        Comparator reverseComparator3 = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (((String) o1).length() >= 11 && ((String) o1).length() >= 11)
                    return Integer.compare(((String) o2).charAt(10), ((String) o1).charAt(10));
                else
                    return 0;
            }
        };

        Arrays.sort(departments, (reverseComparator1.thenComparing(reverseComparator2).thenComparing(reverseComparator3)));
        for (String str : departments) {
            System.out.println(str);
        }
        return departments;
    }
}
