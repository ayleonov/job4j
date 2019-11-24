package ru.job4j.sql;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import org.postgresql.Driver;

public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection conn = null;

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.conn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("login"),
                    config.getProperty("password")
            );
            PreparedStatement st = conn.prepareStatement("CREATE DATABASE tracker IF NOT EXIST");
            st.executeUpdate();
            st = conn.prepareStatement("CREATE TABLE item IF NOT EXIST(id serial primary key, name varchar(20), desc varchar(2000), time Timestamp)");
            st.executeUpdate();
            st.close();

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return conn != null;
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement stat = conn.prepareStatement("insert into item (name,desc,time)values(item.getName(),item.getDesc(), item.getTime()")) {
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean res = false;
        try (PreparedStatement stat = conn.prepareStatement("update into item set(name, desc, time) values(item.getName(),itemDesc(),item.getTime()")) {
            stat.executeUpdate();
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
        List<Item> res = null;
        ResultSet rs = null;
        Item newItem = null;
        try (PreparedStatement stat = conn.prepareStatement("SELECT * FROM item")) {
            while (rs.next()) {
                Timestamp newItemTime = rs.getTimestamp("time");
                String newItemTimeString = newItemTime.toString();
                long newItemTimeLong = Long.parseLong(newItemTimeString);
                newItem = new Item(rs.getString("name"), rs.getString("desc"), newItemTimeLong);
                res.add(newItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> res = null;
        ResultSet rs = null;
        Item newItem = null;
        try (PreparedStatement stat = conn.prepareStatement("SELECT * FROM item WHERE item.name like '%key%'")) {
            while (rs.next()) {
                Timestamp newItemTime = rs.getTimestamp("time");
                String newItemTimeString = newItemTime.toString();
                long newItemTimeLong = Long.parseLong(newItemTimeString);
                newItem = new Item(rs.getString("name"), rs.getString("desc"), newItemTimeLong);
                res.add(newItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public Item findById(String id) {
        Item res = null;
        ResultSet rs = null;
        Item newItem = null;
        try (PreparedStatement stat = conn.prepareStatement("SELECT * FROM item WHERE item.id = id")) {
            if (rs.next()) {
                Timestamp newItemTime = rs.getTimestamp("time");
                String newItemTimeString = newItemTime.toString();
                long newItemTimeLong = Long.parseLong(newItemTimeString);
                res = new Item(rs.getString("name"),rs.getString("desc"),newItemTimeLong);
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
