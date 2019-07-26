package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    public int indexOf(int[] data, int el, int start, int finish) {

        int rst = -1;
        for (int i = 0; i <= finish - start; i++) {
            if (data[start + i] == el) {
                rst = start + i;
                break;
            }
        }
        return rst;
    }

    public int[] sort(int[] data) {
        int temp;
        int tempIndex = -1;
        for (int i = 0; i < data.length; i++) {
            temp = data[i];
            tempIndex = i;

            for (int j = i + 1; j < data.length; j++) {
            if (data[j] < temp){
                    temp = data[j];
                    tempIndex = j;
                }
            }
            data[tempIndex]= data[i];
            data[i] = temp;
        }
        return data;
    }
}
