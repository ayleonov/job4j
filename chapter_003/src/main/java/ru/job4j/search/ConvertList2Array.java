package ru.job4j.search;

import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int position = 0;

        int cells = (int) (Math.ceil(list.size() / rows)) + 1;
        int[][] result = new int[rows][cells];

        for (Integer element : list) {
            for (int[] i : result) {
                for (int j = 0; j < cells - 1; j++) {
      //              result[j] = element;
                }
            }
            //          }
        }
        return result;
    }
}
