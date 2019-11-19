package ru.job4j.exam;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConnectionTest {
    Connection conn = new Connection("./data/source.txt", "./data/target.txt");
    //Connection4 conn = new Connection4("c:/temp/lng.csv", "./data/target.txt");

    @Test
    public void whenTestingCheckconnection() {

        Set<String> set = new HashSet();
        set.add("100");
        set.add("200");
        set.add("700");

        Set<String> set2 = new HashSet();
        set2.add("1100");
        set2.add("400");
        set2.add("1700");

        conn.getParts().put(0, set);
        conn.getParts().put(1, set2);
        System.out.println(conn.getParts().size());
        System.out.println(conn.getParts().get(0));
        System.out.println(conn.getParts().get(1));


        String str = "300;400;600";
        String str2 = "110;100;301";

        assertThat(conn.checkconnection(str), is(1));
        assertThat(conn.checkconnection(str2), is(0));
    }

    @Test
    public void whenTestingWriteInMap() {
        String str = "300;400;600";
        String str2 = "300;500;700";
        String str3 = "800;900;960";

        conn.writeInMap(str);
        //assertThat(conn.getGroups().size(), is(1));
        conn.writeInMap(str2);
        conn.getGroups().size();
        assertThat(conn.getGroups().size(), is(1));
        conn.writeInMap(str3);
        assertThat(conn.getGroups().size(), is(2));
    }

    @Test
    public void whenTestingReadStrings() {
        conn.readStrings();
        assertThat(conn.getParts().size(), is(3));

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