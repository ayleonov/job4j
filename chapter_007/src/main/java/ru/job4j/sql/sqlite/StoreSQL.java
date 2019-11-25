package ru.job4j.sql.sqlite;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ru.job4j.sql.sqlite.XmlUsage.Field;


public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connection;
    private String filename;

    public StoreSQL(Config config) {
        this.config = config;
    }

    public void createNewDataBase(String filename) {
        this.filename = filename;
        String urlBasePart = (config.get("url").split("jdbc:sqlite:"))[1];
        String url = urlBasePart + filename;
        String totalURL = "jdbc:sqlite:" + url;
        File file = new File(url);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            connection = DriverManager.getConnection((totalURL), config.get("user"), config.get("password"));
            //connection = DriverManager.getConnection((config.get("url") + filename), config.get("user"), config.get("password"));
            PreparedStatement st = connection.prepareStatement("   CREATE TABLE IF NOT EXISTS entry(id serial primary key, field integer)");
            st.execute();
            if (connection != null) {
                DatabaseMetaData meta = connection.getMetaData();
                System.out.println("The driver name is: " + meta.getDriverName());
                System.out.println("A new database has been created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generate(int size) {
        PreparedStatement statement;
        try {
            connection = DriverManager.getConnection((config.get("url") + filename), config.get("user"), config.get("password"));
            statement = connection.prepareStatement("delete from entry");
            boolean rs = statement.execute();

            for (int i = 0; i < size; i++) {
                int field = i + 1;

                statement = connection.prepareStatement("insert into entry(field) values(?)");
                statement.setInt(1, field);
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Field> load() {
        List<Field> list = new ArrayList<>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("SELECT*FROM entry");
            while (rs.next()) {
                int value = rs.getInt("field");
                Field f = new Field(value);
                list.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
