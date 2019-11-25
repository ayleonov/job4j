package ru.job4j.sql.sqlite;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ru.job4j.sql.sqlite.XmlUsage.Field;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StoreSQLTest {
    Config config;
    StoreSQL storeSQL;
    File file;

    @Before
    public void beforeTest() {
        config = new Config();
        config.init();
        storeSQL = new StoreSQL(config);
        file = new File("C:/projects/sqlite/db/test.db");
    }

    @Test
    public void whenTestingCreateDatabase() throws IOException {

        // для чистоты проверки: удаляем файл с данного адреса, если он был
        file.delete();
        // проверяем файла базы нет
        assertFalse(file.exists());
        storeSQL.createNewDataBase("test.db");
        // проверяем, что метод создал файл базы данных
        assertTrue(file.exists());

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/projects/sqlite/db/test.db");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM entry");
        ) {
            // проверяем, что пока база пустая.
            assertFalse(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenTestingGenerating() {
        storeSQL.createNewDataBase("test.db");
        storeSQL.generate(4);
        // тестовое содержимое базы выводим в список res
        List<Integer> res = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/projects/sqlite/db/test.db");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM entry");
        ) {
            while (rs.next()) {
                res.add(rs.getInt("field"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //проверяем содержимое базы (список res)
        assertThat(res.get(0), is(1));
        assertThat(res.get(1), is(2));
        assertThat(res.get(2), is(3));
        assertThat(res.get(3), is(4));
    }

    @Test
    public void whenTestingLoadFromDatabase() {
        storeSQL.createNewDataBase("test.db");
        storeSQL.generate(5);
        List<Field> expected = List.of(new Field(1),new Field(2),new Field(3),new Field(4),new Field(5));
        List<Field> res = storeSQL.load();
        for (int i = 0; i < 5; i++) {
            assertThat(res.get(i).getValue(), is(expected.get(i).getValue()));
        }

    }
}