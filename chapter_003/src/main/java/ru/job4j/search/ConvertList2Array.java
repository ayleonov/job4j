package ru.job4j.search;

import java.util.Iterator;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {

        int cells = (int) (Math.ceil(list.size() / rows)) + 1;
        int[][] result = new int[rows][cells];
        Iterator iterator = list.listIterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (iterator.hasNext()) {
                    result[i][j] = (int) (iterator.next());
                }
            }
        }
        return result;
    }
}
