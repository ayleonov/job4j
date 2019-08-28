package ru.job4j.search;

import java.util.Iterator;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {

        int cells = (int) (Math.ceil(list.size() / rows)) + 1;
        int[][] result = new int[rows][cells];
        int i = 0;
        int j = 0;

        for (Integer element : list) {
            result[i][j++] = element;
            //if (j + 1 > cells){
            if (j == result[i].length) {
                i++;
                j = 0;
            }
        }
        return result;
    }
}
