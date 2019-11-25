package ru.job4j.sql.sqlite;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();

    public void init() {
        try (
                InputStream in = Config.class.getClassLoader().getResourceAsStream("app2.properties")) {
            values.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }


}

