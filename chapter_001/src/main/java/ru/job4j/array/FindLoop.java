package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int e1) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e1) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
