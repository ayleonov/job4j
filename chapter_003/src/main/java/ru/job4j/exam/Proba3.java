package ru.job4j.exam;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Proba3 {


    public static void main(String[] args) {

        String[] array4 = {"affff", "dfff", "bfff", "baaa" };
        String[] array2 = {"cffff", "afff", "tfff", "kaaa" };
        String[] array1 = {"zffff", "dfff", "afff", "naaa" };

        Set<String[]> set = new TreeSet<String[]>(new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {

                return o1.toString().compareTo(o2.toString());
            }
        });
        set.add(array1);
        set.add(array2);
        set.add(array4);
        for( String[] a : set){
            System.out.println(a);
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }
    };
}