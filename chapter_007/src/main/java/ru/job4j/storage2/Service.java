package ru.job4j.storage2;

import ru.job4j.storage2.goods.Food;
import ru.job4j.storage2.storages.StoragePlace;
import ru.job4j.storage2.storages.Trash;
import ru.job4j.storage2.storages.Warehouse;
import ru.job4j.storage2.storages.Shop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Service {

    public Service() {
    }

    public static int calculPercent(long min, long max) {
        long curr = System.currentTimeMillis();
        long a = curr - min;
        long b = max - min;
        int percent = (int) (a * 100 / b);
        return (int) (a * 100 / b);
    }

    public static long converterToLong(String str) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(str);
        return date.getTime();
    }

    public static void main(String[] args) throws ParseException {
     /*   for (int i = 1; i < 12; i++) {
            String minS = "2019-11-30";
            String delta = "";
            if (i < 10) {
                delta = "0" + i;
            }
            delta = String.valueOf(i);
            String maxS = "2020-" + delta + "-03";
            long min = converterToLong(minS);
            long max = converterToLong(maxS);
            int percent = calculPercent(min, max);
            System.out.println(String.format("%s %s %d", minS, maxS, percent ));
        }*/
     String a = "2019-11-30";
     String b = "2020-12-03";
        System.out.println(converterToLong(a));
        System.out.println(converterToLong(b));



    }

}
