package ru.job4j.storage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Service {
    private Context context;
    private long curr;

    public Service(long curr) {
        this.curr = curr;
    }

    public Service() {
    }

    public int calculPercent(long min, long max) {
        long curr = System.currentTimeMillis();
        long a = curr - min;
        long b = max - min;
        return (int) (a * 100 / b);
    }

    public long converterToLong(String str) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(str);
        return date.getTime();
    }

    public StoragePlace separate(Food food, int percent) {
        StoragePlace storagePlace;
        if (percent < 25) {
            storagePlace = new Warehouse();
        } else if (percent >= 25 && percent <= 75) {
            storagePlace = new Shop();

        } else if (percent > 75 && percent <= 100) {
            food.setPrice(food.getPrice() * (1 - (food.getDiscount() * 1.0 / 100)));
            storagePlace = new Shop();
        } else {
            storagePlace = new Trash();
        }
        return storagePlace;
    }

       public void shipment(StoragePlace place, double weight) {
           context = new Context(place);
           context.executeStrategy(weight);
       }
}
