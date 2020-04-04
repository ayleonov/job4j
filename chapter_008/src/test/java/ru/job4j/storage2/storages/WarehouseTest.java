package ru.job4j.storage2.storages;

import org.junit.Test;
import ru.job4j.storage2.Service;
import ru.job4j.storage2.goods.Carrot;
import ru.job4j.storage2.goods.Food;

import java.text.ParseException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class WarehouseTest {
    @Test
    public void whenTestingAccept() throws ParseException {
        StoragePlace warehouse = new Warehouse();
        String expireDate = "2020-12-03";
        String createDate = "2019-11-30";

        Food food = new Carrot(createDate, expireDate, 20, 10);
        int percent = Service.calculPercent(Service.converterToLong(createDate), Service.converterToLong(expireDate));
        // тестирование проводится 2020-01-03.  percent = 9;
        //assertThat(percent, is(9));
       // assertTrue(warehouse.accept(food));

        String expireDate2 = "2020-04-03";
        String createDate2 = "2019-11-30";

        Food food2 = new Carrot(createDate2, expireDate2, 20, 10);
        int percent2 = Service.calculPercent(Service.converterToLong(createDate2), Service.converterToLong(expireDate2));
        // тестирование проводится 2020-01-03.  percent = 27;
        //assertThat(percent2, is(27));
        assertFalse(warehouse.accept(food2));


    }
}