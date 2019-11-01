package ru.job4j.io;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ConsoleChat2Test {
    @Test
    public void when() throws IOException {
        List<String> list = List.of("первая фраза", "вторая фраза", "стоп", "третья фраза",
                "четвертая фраза", "продолжить", "пятая фраза", "шестая фраза", "седьмая фраза",
                "закончить", "восьмая фраза", "девятая фраза");
        ConsoleChat2 cch = new ConsoleChat2();
        cch.insertText(list, 2);
    }
}