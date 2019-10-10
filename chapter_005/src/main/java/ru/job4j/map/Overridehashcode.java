package ru.job4j.map;

import java.util.Objects;

public class Overridehashcode {
    private Object testfield;

    public Overridehashcode(Object testfield) {
        this.testfield = testfield;
        ;
    }


    @Override
    public int hashCode() {
        int res = 1;
        int c = additiveCalculate(testfield);

        return 31 * res + c;
    }

    private int additiveCalculate(Object f) {
        int res = 0;

        if (f instanceof Boolean) {
            res = f.equals(false) ? 0 : 1;
        }
        if (f instanceof Number) {
            res = ((Number) f).intValue();
        }
        if (f instanceof Character) {
            res = ((Character) f).charValue();
        }

        if (f instanceof Long) {
            int a = ((Long) f).intValue();
            res = ((a) ^ (a >>> 32));
        }

        if (f instanceof Float) {
            int a = ((Float) f).intValue();
            res = Float.floatToIntBits(a);;
        }

        if (f instanceof Double) {
            int a = ((Double) f).intValue();
            long res1 = Double.doubleToLongBits(a);
            int b = ((Long) res1).intValue();
            res = ((b) ^ (b >>> 32));
        }

        if (f instanceof Object) {
            res = (f == null ? 0 : f.hashCode());
        }
        return res;
    }
}
