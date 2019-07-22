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
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j <= 9; j++) {
            int currentIndex = indexOf(data, j, 0, data.length-1);
                if (currentIndex !=-1){
                    temp = data[i];
                    data[i]=data[currentIndex];
                    data[currentIndex]= temp;
                }
            }
        }
        return data;
    }
}
