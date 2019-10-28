package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SearchTest {
    @Test
    public void whenFind9JavaAndTxtFiles() {
        Search sr = new Search();

        List groupExt = List.of("java", "txt");
        System.getProperty("java.io.tmpdir");
        String pathParent = "c:/temp/tmpdir";
        // программа выделяет файлы с указанными расширениями
        List<File> result = sr.findFiles(pathParent, groupExt);
        // проверяем, что всего файлов с заданными расширениями - 9 шт
        assertThat(result.size(), is(9));
        // список имен реальных файлов
        List<String> realfilesOnComputer = List.of("000.java", "000text.txt", "001.java", "001text.txt", "002_7.txt", "002.java", "002text.txt", "003text.txt", "003.java");

        for (int i = 0; i < result.size(); i++) {
            assertTrue(realfilesOnComputer.contains(result.get(i).getName()));
        }
    }
}