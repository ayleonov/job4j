package ru.job4j.sql;
import ru.job4j.tracker.*;
//import ru.job4j.tracker.ITracker;
//import ru.job4j.tracker.Item;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class TrackerSQL implements ITracker, AutoCloseable {
    private Connection conn;

    public TrackerSQL(Connection conn) {
        this.conn = conn;
    }

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            String sql = "CREATE TABLE IF NOT EXISTS item (id serial primary key, name varchar(20), descr varchar(2000), time Timestamp)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return conn;
    }
    @Override
    public Item add(Item item) {
        try (PreparedStatement stat = conn.prepareStatement("insert into item (name,descr,time)values(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stat.setString(1, item.getName());
            stat.setString(2, item.getDesc());
            stat.setTimestamp(3, new Timestamp(item.getTime()));
            stat.executeUpdate();
            try (ResultSet rs = stat.getGeneratedKeys()) {
                if (rs.next()) {
                    item.setId(String.valueOf(rs.getString(1)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
    @Override
    public boolean replace(String id, Item item) {
        boolean res = false;
        try (PreparedStatement stat = conn.prepareStatement("update item set name = ?, descr = ?, time = ? WHERE id=?")) {
            stat.setString(1, item.getName());
            stat.setString(2, item.getDesc());
            stat.setTimestamp(3, new Timestamp(item.getTime()));
            stat.setInt(4, Integer.parseInt(id));
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
        try (PreparedStatement stat = conn.prepareStatement("DELETE FROM item where item.id = ?")) {
            stat.setInt(1, Integer.parseInt(id));
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
        try (PreparedStatement stat = conn.prepareStatement("SELECT * FROM item");
             ResultSet rs = stat.executeQuery();) {
            while (rs.next()) {
                Item newItem = new Item(rs.getString("name"), rs.getString("descr"), rs.getTimestamp("time").getTime());
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
        try (PreparedStatement stat = conn.prepareStatement("SELECT * FROM item WHERE name like ?")) {
            stat.setString(1, "%" + key + "%");
            try (ResultSet rs = stat.executeQuery()) {
                while (rs.next()) {
                    Item newItem = new Item(rs.getString("name"), rs.getString("descr"), rs.getTimestamp("time").getTime());
                    newItem.setId(String.valueOf(rs.getInt("id")));
                    res.add(newItem);
                }
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
        try (PreparedStatement stat = conn.prepareStatement("SELECT * FROM item WHERE item.id = id");
             ResultSet rs = stat.executeQuery();) {
            if (rs.next()) {
                res = new Item(rs.getString("name"), rs.getString("descr"), rs.getTimestamp("time").getTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}
