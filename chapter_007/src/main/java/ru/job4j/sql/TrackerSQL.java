package ru.job4j.sql;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.postgresql.Driver;

import javax.xml.transform.Result;

public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection conn = null;

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.conn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("user"),
                    config.getProperty("password")
            );
            PreparedStatement st = conn.prepareStatement("CREATE TABLE IF NOT EXISTS item (id serial primary key, name varchar(20), descr varchar(2000), time Timestamp);");
            st.executeUpdate();
            st.close();

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return conn != null;
    }

    @Override
    public Item add(Item item) {

        try (PreparedStatement stat = conn.prepareStatement("insert into item (name,descr,time)values(item.getName(),item.getDesc(), item.getTime()")) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean res = false;
        try (PreparedStatement stat = conn.prepareStatement("update item set name = item.getName(), descr = item.getDesc(), time = item.getTime()")) {
        //     stat.executeUpdate();
            res = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res = false;
        try (PreparedStatement stat = conn.prepareStatement("DELETE FROM item where item.id = id")) {
            stat.executeUpdate();
            res = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Item> findAll() {
        List<Item> res = new ArrayList<>();
        ResultSet rs = null;
        Item newItem = null;
        try (PreparedStatement stat = conn.prepareStatement("SELECT * FROM item")) {
            rs = stat.executeQuery();
            while (rs.next()) {
                newItem = new Item(rs.getString("name"), rs.getString("descr"), rs.getTimestamp("time").getTime());
                res.add(newItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> res = new ArrayList<>();
        ResultSet rs = null;
        Item newItem = null;
        try (PreparedStatement stat = conn.prepareStatement("SELECT * FROM item WHERE name like '%?%'")) {
         stat.setString(1,key);
            rs = stat.executeQuery();
            while (rs.next()) {
                newItem = new Item(rs.getString("name"), rs.getString("descr"), rs.getTimestamp("time").getTime());
                res.add(newItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        List a = res;
        return res;
    }

    @Override
    public Item findById(String id) {
        Item res = null;
        ResultSet rs = null;
        Item newItem = null;
        try (PreparedStatement stat = conn.prepareStatement("SELECT * FROM item WHERE item.id = id")) {
            rs = stat.executeQuery();
            if (rs.next()) {
                res = new Item(rs.getString("name"),rs.getString("descr"),rs.getTimestamp("time").getTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void close() throws Exception {

    }

    public Connection getConn() {
        return conn;
    }
}
