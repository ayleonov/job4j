package ru.job4j.sql.sqlite;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void whenTestingReceivingProperties()  {
        Config config = new Config();
        config.init();
        assertThat (config.get("url"), is("jdbc:sqlite:C:/projects/sqlite/db/"));
        assertThat (config.get("user"), is("ayleonov"));
        assertThat (config.get("password"), is("password"));
    }

}