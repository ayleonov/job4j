package ru.job4j.liquibase;

import org.junit.*;
import ru.job4j.sql.TrackerSQL;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ru.job4j.tracker.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class TrackerSQL2Test {
  /*  @Test
    public void createItem() throws ParseException {

        TrackerSQL tracker = new TrackerSQL();
        tracker.init();
        int numberItemsBeforeCreate = tracker.findByName("name").size();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        String timeStr = "2020-09-01";
        Date date = df.parse(timeStr);
        long time = date.getTime();
        tracker.add(new Item("name", "desc", time));
        int numberItemsAfterCreate = tracker.findByName("name").size();
        assertThat(numberItemsAfterCreate - numberItemsBeforeCreate, is(1));
    }*/
}
