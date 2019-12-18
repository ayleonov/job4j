package ru.job4j.sql;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {
    TrackerSQL tr;
    private boolean isConnected;
    private List<Item> list;
    Connection connection;

    @Before
    public void beforeTest() throws SQLException {
        try (InputStream in = TrackerSQLTest.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
            config.getProperty("url"), config.getProperty("user"),
                    config.getProperty("password"));
            tr = new TrackerSQL();
            isConnected = tr.init();
            insertItem();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }
    }

    @After
    public void afterTest() throws SQLException {
        connection.close();
    }


    @Test
    public void whenTestingInit() {
        assertTrue(isConnected);
    }

    @Test
    public void whenTestingFindByName() {
        List<Item> res = tr.findByName("ite");
        assertThat(res, is(list));
    }

    @Test
    public void whenTestingAdd() {
        String dateStr = "2020-08-23";
        long time = convertDateToLong(dateStr);
        Item item = new Item("item2", "description2", time);
        tr.add(item);
        List<Item> expect = tr.findByName("item2");
        Item expectItem = expect.get(0);
        assertThat(expectItem.getName(), is("item2"));
        assertThat(expectItem.getDesc(), is("description2"));
        assertThat(expectItem.getTime(), is(time));
        assertTrue(expect.contains(item));
    }


    @Test
    public void whenTestingReplace() {

        Item first = tr.findByName("item").get(0);
        String idFirst = first.getId();
        String timeDate = "2020-01-01";
        long secondTime = convertDateToLong(timeDate);
        Item second = new Item("second", "descrSecond", secondTime);
        second.setId(idFirst);
        tr.replace(idFirst, second);
        List<Item> afterreplace = tr.findByName("seco");
        Item third = afterreplace.get(0);
        assertThat(third.getName(), is("second"));
        assertThat(third.getDesc(), is("descrSecond"));
        assertThat(third.getTime(), is(secondTime));
        assertTrue(afterreplace.contains(second));
    }

    @Test
    public void whenTestingDelete() {
        List<Item> beforedelete = tr.findByName("item");
        Item first = beforedelete.get(0);
        String idFirst = first.getId();
        assertTrue(tr.delete(idFirst));
        List<Item> afterdelete = tr.findByName("item");

        assertThat(beforedelete.size(), is(1));
        assertThat(afterdelete.size(), is(0));
    }

    @Test
    public void whenTestingFindById() {
        List<Item> items = tr.findByName("item");
        Item first = items.get(0);
        String idFirst = first.getId();
        Item res = tr.findById(idFirst);

        assertEquals(first.getName(), res.getName());
        assertEquals(first.getDesc(), res.getDesc());
        assertEquals(first.getTime(), res.getTime());

        res.setId(idFirst);

        assertEquals(first.getId(), res.getId());
        assertEquals(first, res);
        assertTrue(items.contains(res));
    }


    @Test
    public void whenTestingFindAll() {
        String dateStr = "2020-08-23";
        long time = convertDateToLong(dateStr);
        Item item = new Item("item2", "description2", time);
        tr.add(item);
        List<Item> allItems = tr.findAll();
        assertThat(allItems.size(), is(2));
        assertThat(allItems.get(0).getName(), is("item001"));
        assertThat(allItems.get(1).getName(), is("item2"));
    }

    private void insertItem() throws SQLException {
        list = new ArrayList();
        PreparedStatement stat = connection.prepareStatement("delete from item");
        stat.executeUpdate();
        PreparedStatement stat2 = connection.prepareStatement("insert into item (name, descr, time) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        stat2.setString(1, "item001");
        stat2.setString(2, "descr001");
        Timestamp a = convertDateToTimestamp("2020-10-14");
        stat2.setTimestamp(3, a);
        stat2.executeUpdate();
        ResultSet rs = stat2.getGeneratedKeys();
        if (rs.next()) {
            Item b = new Item("item001", "descr001", a.getTime());
            b.setId(String.valueOf(rs.getInt("id")));
            list.add(b);
        }
    }

    public Timestamp convertDateToTimestamp(String dateStr) {
        long time = 0;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateStr);
            time = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Timestamp(time);
    }

    public long convertDateToLong(String dateStr) {
        long time = 0;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateStr);
            time = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}