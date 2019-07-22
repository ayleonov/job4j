package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    public String[] remove(String[] array) {
        int m;
        int limit = array.length;
        for (int i = 1; i < limit; ) {
            m = 0;
            for (int j = 0; j < i; j++) {
                if (!(array[j].equals(array[i]))) {
                    continue;
                } else {
                    String[] arrayNew = moving(array, i);
                    for (int l = 0; l < arrayNew.length; l++) {
                        array[l] = arrayNew[l];
                        m = 1;
                    }
                }
                break;
            }

            if (m != 1) {
                i++;
            } else {
                limit--;
            }
        }
        return Arrays.copyOf(array, limit);
    }

    private String[] moving(String arr[], int start) {
        String temp = arr[start];
        for (int k = start; k < arr.length - 1; k++) {
            arr[k] = arr[k + 1];
        }
        arr[arr.length - 1] = temp;

        return arr;
    }

}
