package ru.job4j.sql.sqlite;

import org.junit.Test;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ConvertXSQTTest {
    @Test
    public void whenTestingConvert() throws TransformerException, IOException {
        ConvertXSQT con = new ConvertXSQT();
        File source = new File("./data/first.xml");
        File dest = new File ("./data/scheme.xml");
        File scheme= new File ("./data/scheme.xml");
        con.convert(source,dest,scheme);
    }

    @Test
    public void whenParsing() {

    }

}