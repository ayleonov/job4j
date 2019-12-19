package ru.job4j.sql.parservacancy;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ParserVacanciesTest {
    Connection conn;
    ParserVacancies pw;

    @Before
    public void beforeTest() {
        pw = new ParserVacancies();
        try (InputStream in = ParserVacancies.class.getClassLoader().getResourceAsStream("app2.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            conn = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
            config.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testingInit() {
        assertNotNull(pw.init());
        assertNotNull(conn);
    }

    @Test
    public void testingCreateTable() {

    }

    @Test
    public void testingWorkJsoup() {
        pw.workJsoup();
    }

}