package ru.job4j.sql.parservacancy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ParserVacancies implements AutoCloseable {
    Connection conn;


    public ParserVacancies(Connection conn) {
        this.conn = conn;
    }

    public ParserVacancies() {
    }

    public Connection init() {
        Properties config = new Properties();
        try (InputStream in = ParserVacancies.class.getClassLoader().getResourceAsStream("app2.properties")) {
            Class.forName(config.getProperty("driver-class-name"));
            conn = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
            config.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void creatTables() {
        try (  PreparedStatement stat = conn.prepareStatement("CREATE TABLE IF NOT EXISTS vacancy(id serial primery key , name varchar(2000), text varchar(2000), link varchar(2000)")){
            stat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void workJsoup() {
        //String url ="https://www.sql.ru/forum/job-offers";
        String url = "yandex.ru";
        try {
            Document doc = Jsoup.connect(url).
                    get();
            String title = doc.title();
            System.out.println(title);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}
