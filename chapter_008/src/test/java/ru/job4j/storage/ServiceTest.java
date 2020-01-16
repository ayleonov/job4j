package ru.job4j.storage;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ServiceTest {
    Service service;
    @Before
    public void beforeTest(){
        service = new Service();
    }

    @Test
    public void whenTestingConverter() throws ParseException {
        String data = "2019-12-03";
        String data2 = "2020-11-30";
        long res = service.converterToLong(data);
        long res2 = service.converterToLong(data2);
        long expected = (new SimpleDateFormat("yyyy-MM-dd")).parse(data).getTime();
        long expected2 = (new SimpleDateFormat("yyyy-MM-dd")).parse(data2).getTime();

        assertThat(res, is(expected));
        assertThat(res2, is(expected2));
        assertThat(res, is(1575320400000L));
        assertThat(res2, is(1606683600000L));
    }

    @Test
    public void whenTestingCalculPercent() throws ParseException {
        long curr = System.currentTimeMillis();
        Service service = new Service(curr);
        String data = "2019-12-03";
        String data2 = "2020-11-30";
        long a = service.converterToLong(data);
        long b = service.converterToLong(data2);
        int res = service.calculPercent(a,b);
        int expected = (int)((curr-a)*100/(b-a));

        assertThat(res, is(expected));
        assertThat(res, is(8));
    }

    @Test
    public void whenTestingResultClassesSeparate() {
        Food food = new Carrot(0L, 0L, 20, 2);
        StoragePlace res = service.separate(food, 3);
        assertTrue(res instanceof Warehouse);
        assertFalse(res instanceof Shop);

        StoragePlace res2= service.separate(food, 30);
        assertTrue(res2 instanceof Shop);
        assertFalse(res2 instanceof Trash);

        StoragePlace res3= service.separate(food, 80);
        assertTrue(res3 instanceof Shop);
        assertFalse(res3 instanceof Trash);

        StoragePlace res4= service.separate(food, 103);
        assertTrue(res4 instanceof Trash);
        assertFalse(res4 instanceof Shop);
    }


}
