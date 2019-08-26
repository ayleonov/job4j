package ru.job4j.search;

import java.util.List;
import java.util.ListIterator;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {

        int cells = (int) (Math.ceil(list.size() / rows)) + 1;
        ListIterator<Integer> iterator = list.listIterator();
        int[][] result = new int[rows][cells];
        for (int[] i : result) {
            for (int j = 0; j < cells; j++) {
                if (iterator.hasNext()) {
                    i[j] = iterator.next();
                }
            }
        }


        return result;
    }
}
