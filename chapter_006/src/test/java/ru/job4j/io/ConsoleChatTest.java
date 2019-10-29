package ru.job4j.io;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ConsoleChatTest {
    @Test
    public void when() throws IOException {
    ConsoleChat cch = new ConsoleChat();
    cch.insertText();
    }
}