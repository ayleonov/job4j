package ru.job4j.sql.sqlite;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ParserXMLTest {

    @Test
            public void whenTestingStartParsing() {
        ParserXML pars = new ParserXML();
        pars.startParsing(new File("./data/second.xml"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(out));

        assertThat(out.toString(), is(new StringBuilder()
                .append("start parsing...\n")
                //.append("result: 10\n")
                //.append("end parsing...\n")
                .toString()));
        System.setOut(stdout);
    }

}