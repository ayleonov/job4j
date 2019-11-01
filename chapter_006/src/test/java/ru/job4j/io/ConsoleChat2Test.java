package ru.job4j.io;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat2Test {
    @Test
    public void when() throws IOException {
        List<String> list = List.of("первая фраза", "вторая фраза", "стоп", "третья фраза",
                "четвертая фраза", "продолжить", "пятая фраза", "шестая фраза", "седьмая фраза",
                "закончить", "восьмая фраза", "девятая фраза");

        ConsoleChat2 cch = new ConsoleChat2();
        cch.insertText(list, 2);
        List<String> insertedStrings = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("./data/textconsole.log"));
        while (br.ready()) {
            String text = br.readLine();
            insertedStrings.add(text);
        }
        br.close();

        assertTrue(insertedStrings.get(2).contains("первая фраза"));
        assertTrue(insertedStrings.get(4).contains("вторая фраза"));
        assertTrue(insertedStrings.get(6).contains("стоп"));
    }

}