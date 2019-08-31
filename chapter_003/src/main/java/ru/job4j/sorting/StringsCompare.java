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
        int cyclestatus = 0;

        for (int i = 0; i < lenghtMin; i++) {
            if (arrleft[i] != arrright[i]) {
                result = Character.compare(arrleft[i], arrright[i]);;
                cyclestatus = 1;
                break;
            }
        }

        if (cyclestatus != 1) {
            if (delta == 0) {
                result = 0;
            } else {
                result = delta > 0 ? 1 : -1;
            }
        }
        return result;
    }
}
