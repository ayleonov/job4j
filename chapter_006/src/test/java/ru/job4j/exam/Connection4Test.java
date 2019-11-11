package ru.job4j.exam;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Connection4Test {
    Connection4 conn = new Connection4("./data/source.txt", "./data/target.txt");
    //Connection4 conn = new Connection4("c:/temp/lng.csv", "./data/target.txt");

    @Test
    public void whenTestingCheckconnection() {

        StringBuilder sb001 = new StringBuilder().append("100;200;700");
        StringBuilder sb002 = new StringBuilder().append("1100;400;1700");

        conn.getGroups().put(0, sb001);
        conn.getGroups().put(1, sb002);
        System.out.println(conn.getGroups().size());
        System.out.println(conn.getGroups().get(0));
        System.out.println(conn.getGroups().get(1));


        String str = "300;400;600";

        int res = conn.checkconnection(str);
        assertThat(res, is(1));
    }

    @Test
    public void whenTestingWriteInMap() {
        String str = "300;400;600";
        String str2 = "300;500;700";
        String str3 = "800;900;960";

        conn.writeInMap(str);
        assertThat(conn.getGroups().size(), is(1));
        conn.writeInMap(str2);
        assertThat(conn.getGroups().size(), is(1));
        conn.writeInMap(str3);
        assertThat(conn.getGroups().size(), is(2));
    }

    @Test
    public void whenTestingReadStrings() {
        conn.readStrings();
        assertThat(conn.getGroups().size(), is(3));

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