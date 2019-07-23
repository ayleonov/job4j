package ru.job4j.array;


public class MatrixCheck {

    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean tempFirst = data[0][0];
        boolean tempSecond = data[0][data.length - 1];

        for (int i = 0; i < data.length; i++) {
            if ((data[i][i] != tempFirst) || (data[i][data.length - 1 - i] != tempSecond)) {
                return false;
            }
        }
        return true;
    }
}
