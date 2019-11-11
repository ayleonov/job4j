package ru.job4j.exam;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class Connection3Test {
    Connection3 conn = new Connection3("./data/source.txt", "./data/target.txt");

    @Test
    public void whenTestingCheckconnection() {
        List<String[]> list1 = new ArrayList<>();
        List<String[]> list2 = new ArrayList<>();
        String[] arr001 = {"100", "200", "700"};
        String[] arr002 = {"1100", "400", "1700"};
        list1.add(arr001);
        list2.add(arr002);

        conn.getGroups().put(0, list1);
        conn.getGroups().put(1, list2);

        String[] arr = {"300", "400", "600"};

        int res = conn.checkconnection(arr);
        assertThat(res, is(1));
    }

    @Test
    public void whenTestingWriteInMap() {
        String[] arr = {"300", "400", "600"};
        String[] arr2 = {"300", "500", "700"};
        String[] arr3 = {"800", "900", "960"};
        conn.writeInMap(arr);
        assertThat(conn.getGroups().size(), is(1));
        conn.writeInMap(arr2);
        assertThat(conn.getGroups().size(), is(1));
        conn.writeInMap(arr3);
        assertThat(conn.getGroups().size(), is(2));
    }

    @Test
    public void whenTestingReadStrings() {
        conn.readStrings();
        assertThat(conn.getGroups().size(), is(3));
        assertThat(conn.getGroups().get(0).size(), is(3));
        assertThat(conn.getGroups().get(1).size(), is(2));
        assertThat(conn.getGroups().get(2).size(), is(1));
    }

    @Test
    public void whenTestingWriteGroups() {
        conn.start();
    }

    @Test
    public void whenTestingWriteGroups2() throws IOException {
        conn.start();
        String source = "./data/target.txt";
        List<String> res = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(source));
        while (br.ready()) {
            res.add(br.readLine());
        }
        br.close();
        assertThat(res.get(0), is("Группа 1"));
        assertThat(res.get(1), is("100;200;300"));
        assertThat(res.get(2), is("400;500;200"));
        assertThat(res.get(3), is("400;200;100"));
        assertThat(res.get(5), is("Группа 2"));
        assertThat(res.get(6), is("600;700;800"));
        assertThat(res.get(7), is("700;1000;1100"));
        assertThat(res.get(9), is("Группа 3"));
        assertThat(res.get(10), is("900;910;920"));
    }

}