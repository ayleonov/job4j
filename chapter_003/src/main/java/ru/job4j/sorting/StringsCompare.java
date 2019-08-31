package ru.job4j.sorting;

import java.util.Comparator;

public class StringsCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = -2;
        char[] arrleft = left.toCharArray();
        char[] arrright = right.toCharArray();
        int delta = arrleft.length - arrright.length;
        int lenghtMin = delta <= 0 ? arrleft.length : arrright.length;
        int strcompare = 0;

        for (int i = 0; i < lenghtMin; i++) {
            strcompare = Character.compare(arrleft[i], arrright[i]);
            if (arrleft[i] != arrright[i]) {
                result = strcompare;
                break;
            }
        }
        if (delta == 0) {
            result = 0;
        } else {
            result = delta > 0 ? -1 : 1;
        }


        return result;
    }
}
