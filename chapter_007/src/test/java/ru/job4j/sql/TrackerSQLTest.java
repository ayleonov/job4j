package ru.job4j.sql;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {
    TrackerSQL tr;
    private boolean isConnected;
    private List<Item> list = null;

    @Before
    public void beforeTest() {
        tr = new TrackerSQL();
        isConnected = tr.init();
    }

    @Test
    public void whenTestingReplace() throws SQLException {
        String dateStr = "2020-08-24";
        long time = convertDateToLong(dateStr);
        Item item = new Item("item2", "description2", time);
        tr.add(item);
        PreparedStatement stat = tr.getConn().prepareStatement("SELECT item.id FROM item WHERE item.name = item2", Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stat.getGeneratedKeys();
        int itemId = 0;
        if (rs.next()) {
            itemId = rs.getInt(1);
        }
        String dateStr2 = "2020-10-12";
        long time2 = convertDateToLong(dateStr2);
        Item item2 = new Item("item3", "description3", time2);
        tr.replace(String.valueOf(itemId), item2);
        PreparedStatement st = tr.getConn().prepareStatement("SELECT * FROM item WHERE item.id=?");
        st.setInt(1, itemId);
        ResultSet res = st.executeQuery();

        if (res.next()) {
            assertThat(res.getString("name"), is("item3"));
            assertThat(res.getString("descr"), is("description3"));
            assertThat(res.getTimestamp("time"), is(dateStr2));
        }
        rs.close();
        stat.close();
        tr.getConn().close();
    }

    @Test
    public void whenTestingDelete() throws SQLException {
        int resId = 0;
        String dateStr4 = "2020-10-12";
        long time4 = convertDateToLong(dateStr4);
        Item item4 = new Item("item4", "description4", time4);

        PreparedStatement stat = tr.getConn().prepareStatement("SELECT item.id FROM item WHERE item.name='item4'");
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            resId = rs.getInt("id");
        }

        tr.delete(String.valueOf(resId));
        stat = tr.getConn().prepareStatement("SELECT * FROM item WHERE item.id=?");
        stat.setInt(1, resId);
        ResultSet rs2 = stat.executeQuery();
        boolean isExist = false;
        if (rs2.next()) {
            isExist = true;
        }
        assertFalse(isExist);
        rs.close();
        stat.close();
        tr.getConn().close();
    }

    @Test
    public void whenTestingFindAll() {
        inserted3ItemsInDB();
        List<Item> res = tr.findAll();
        assertEquals(res, list);
        assertEquals(res.get(0).getName(), list.get(0).getName());
        assertEquals(res.get(0).getDesc(), list.get(0).getDesc());
        assertEquals(res.get(0).getTime(), list.get(0).getTime());
    }

    @Test
    public void whenTestingFindByName() {
        inserted3ItemsInDB();
        List<Item> res = tr.findByName("ite");
        assertThat(res, is(list));
        //assertEquals(res, list);
        assertEquals(res.get(0).getName(), list.get(0).getName());
    }

    @Test
    public void whenTestingFindById() {
        inserted3ItemsInDB();
        Item res = tr.findById("3");
        assertThat(res, is(list.get(0)));

        assertEquals(res.getName(), list.get(0).getName());
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

    public void inserted3ItemsInDB() {
        list = new ArrayList();
        try {
            PreparedStatement stat = tr.getConn().prepareStatement("DELETE FROM item");
            stat.execute();
            String dateStr5 = "2020-10-14";
            long time5 = convertDateToLong(dateStr5);
            Item item5 = new Item("item5", "description5", time5);
            stat = tr.getConn().prepareStatement("insert into item (name, descr, time) values ('item5','description5','2020-10-14')");
            stat.execute();

            String dateStr6 = "2020-10-15";
            long time6 = convertDateToLong(dateStr6);
            Item item6 = new Item("item6", "description6", time6);
            stat = tr.getConn().prepareStatement("insert into item (name, descr, time) values ('item6','description6','2020-10-15')");
            stat.execute();

            String dateStr7 = "2020-10-16";
            long time7 = convertDateToLong(dateStr7);
            Item item7 = new Item("item7", "description7", time7);
            stat = tr.getConn().prepareStatement("insert into item (name, descr, time) values ('item7','description7','2020-10-16')");
            stat.execute();

            stat = tr.getConn().prepareStatement("Select * from item");
            ResultSet rs = stat.executeQuery();
            list.add(item5);
            list.add(item6);
            list.add(item7);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
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
        if (rs.next()) {
            assertNotNull(rs);
            assertThat(rs.getString("descr"), is("description1"));
            assertThat(rs.getTimestamp("time"), is(convertDateToTimestamp(dateStr)));
        }
        rs.close();
        stat.close();
        tr.getConn().close();
    }
}