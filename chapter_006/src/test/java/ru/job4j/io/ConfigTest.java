package ru.job4j.io;

import org.junit.Test;


import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ConfigTest {
    @Test
    public void when() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Aleksey Leonov"));
    }

    @Test
    public void when2() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
    }
}