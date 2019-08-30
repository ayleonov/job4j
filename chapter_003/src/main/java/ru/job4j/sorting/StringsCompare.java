package ru.job4j.sorting;

import java.util.Comparator;

public class StringsCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = -2;
        char[] arrleft = left.toCharArray();
        char[] arrright = right.toCharArray();
        int lenghtMin = arrleft.length <= arrright.length ? arrleft.length : arrright.length;
        for (int i = 0; i < lenghtMin; i++) {
            int strcompare = Character.compare(arrleft[i], arrright[i]);
            if (strcompare != 0) {
                result = strcompare;
                break;
            } else if (arrleft.length == arrright.length) {
                result = 0;
            }
        }
        return result;
    }
}
