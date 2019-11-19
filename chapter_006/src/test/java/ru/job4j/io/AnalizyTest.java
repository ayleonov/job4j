package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AnalizyTest {
    @Test
    public void when() throws IOException {
        Analizy analizy = new Analizy();
        String source = "./data/server.txt";
        String target = "./data/target.txt";
        analizy.unavailable(source, target);
        Set set = new HashSet();
        BufferedReader bufread = new BufferedReader(new FileReader(target));
        while (bufread.ready()) {
            set.add(bufread.readLine());
        }
        // проверяем, что в множестве 2 элемента
        assertThat(set.size(), is(2));
        String firstTimeout = "10:57:01 10:59:01";
        String secondTimeout = "10:57:01 10:59:01";
        // проверяем, что в тест-множестве из 2 элементов есть заданные
        assertTrue(set.contains(firstTimeout));
        assertTrue(set.contains(secondTimeout));
    }
}