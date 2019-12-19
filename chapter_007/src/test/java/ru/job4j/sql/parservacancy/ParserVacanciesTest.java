package ru.job4j.sql.parservacancy;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ParserVacanciesTest {
    Connection conn;
    @Before
    public void beforeTest() {
        Properties config = new Properties();
        try (InputStream in = ParserVacancies.class.getClassLoader().getResourceAsStream("app2.properties")) {
            Class.forName(config.getProperty("driver-class-name"));
            conn = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
            config.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testingInit() {
        ParserVacancies pw = new ParserVacancies();
    assertThat(pw.init(),is(conn));
    }

    @Test
    public void testingJsout() {

    }
}