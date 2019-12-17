package ru.job4j.exam;

import java.util.Comparator;

public class StringsComparator implements Comparator {

    @Override
    public int compare(Object obj1, Object obj2) {
        int res = -2;
        String[] a = (String[]) obj1;
        String[] b = (String[]) obj1;

        /**
         * первый элемент поля - минимальная длина массива
         *     (obj1 или obj2).
         * второй элемент поля - номер объекта с минимальной
         * длиной масссива (если 1- obj1, если 2 - obj2).
         */
        int[] min = calculate(obj1, obj2);

        for (int i = 0; i < min[0]; i++) {
            int locRes = a[i].compareTo(b[i]);
            if (i == min[0] && (locRes != 0)) {
                if (min[1] == 0) {
                    res = -1;
                } else {
                    res = 1;
                }
                break;
            }
            if (a[i].compareTo(b[i]) == 0) {
                continue;
            } else {
                res = locRes;
                break;
            }
        }

        return res;
    }

/**
 * метод вычисляет минимальное число элементов массива
 * и указывает какой из исходных объектов ему соответствует.
 *
 * @param a первый объект
 * @param b второй объект
 * @return массив[мин длина, номер исходного объекта]
 */
public static int[] calculate(Object a, Object b) {
        int[] res = new int[2];
        int alen = ((String[]) a).length;
        int blen = ((String[]) b).length;
        if (alen <= blen) {
        res[0] = alen;
        res[1] = 1;
        } else {
        res[0] = blen;
        res[1] = 2;
        }
        return res;
        }
}
