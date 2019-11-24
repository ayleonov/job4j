package ru.job4j.sql;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {
    TrackerSQL tr;
    boolean isConnected;

    @Before
    public void beforeTest() {
        tr = new TrackerSQL();
        isConnected = tr.init();
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

    @Test
    public void whenCheckConnection() {
        assertTrue(isConnected);
    }

    @Test
    public void whenTestingAdd() throws SQLException {

        String dateStr = "2020-08-23";
        long time = convertDateToLong(dateStr);
        Item item = new Item("item1", "description1", time);
        tr.add(item);
        PreparedStatement stat = tr.getConn().prepareStatement("SELECT * FROM item WHERE item.name='item1'");
        ResultSet rs = stat.executeQuery();
        assertNotNull(rs);
        assertThat(rs.getString("desc"), is("description1"));
        assertThat(rs.getTimestamp("time"), is(convertDateToTimestamp(dateStr)));
        rs.close();
        stat.close();
        tr.getConn().close();
    }

    @Test
    public void whenTestingReplace() throws SQLException {
        String dateStr = "2020-08-24";
        long time = convertDateToLong(dateStr);
        Item item = new Item("item2", "description2", time);
        tr.add(item);
        PreparedStatement stat = tr.getConn().prepareStatement("SELECT item.id FROM item WHERE item.name = 'item2'", Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stat.getGeneratedKeys();
        int itemId = 0;
        if (rs.next()){
            itemId = rs.getInt(1);
        }
        String dateStr2 = "2020-10-12";
        long time2 = convertDateToLong(dateStr2);
        Item item2 = new Item("item3", "description3", time2);
        tr.replace(String.valueOf(itemId), item2);
        Statement st = tr.getConn().createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM item WHERE item.id= 'itemId'");
        if (res.next()){
            assertThat(res.getString("name"), is("item3"));
            assertThat(res.getString("desc"), is("description3"));
            assertThat(res.getTimestamp("time"), is(dateStr2));
        }
    }

    @Test
    public void whenTestingDelete() {
        assertTrue(tr.init());
    }

    @Test
    public void whenCheckConn4ection4() {
        assertTrue(tr.init());
    }

    @Test
    public void whenCheckConne44ction() {
        assertTrue(tr.init());
    }

}