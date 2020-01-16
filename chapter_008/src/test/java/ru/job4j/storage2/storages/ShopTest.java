package ru.job4j.storage2.storages;

import org.junit.Test;
import ru.job4j.storage2.Service;
import ru.job4j.storage2.goods.Carrot;
import ru.job4j.storage2.goods.Food;

import java.text.ParseException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ShopTest {
    @Test
    public void whenTestingAccept() throws ParseException {
        StoragePlace shop = new Shop();
        String expireDate = "2020-12-03";
        String createDate = "2019-11-30";

        Food food = new Carrot(createDate, expireDate, 20, 10);
        int percent = Service.calculPercent(Service.converterToLong(createDate), Service.converterToLong(expireDate));
        assertFalse(shop.accept(food));

        String expireDate2 = "2020-04-03";
        String createDate2 = "2019-11-30";

        Food food2 = new Carrot(createDate2, expireDate2, 20, 10);
        int percent2 = Service.calculPercent(Service.converterToLong(createDate2), Service.converterToLong(expireDate2));
        // тестирование проводится 2020-01-03.  percent = 27;
        //assertThat(percent2, is(27));
        assertTrue(shop.accept(food2));

        String expireDate3 = "2020-01-13";
        String createDate3 = "2019-11-30";

        Food food3 = new Carrot(createDate3, expireDate3, 20, 10);
        int percent3 = Service.calculPercent(Service.converterToLong(createDate3), Service.converterToLong(expireDate3));
        System.out.println(percent3);
        // тестирование проводится 2020-01-03.  percent = 79;
        //assertThat(percent3, is(79));
    }
}