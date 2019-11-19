package ru.job4j.otherversions;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConnectionTest {
    private Connection conn = new Connection("./data/source.txt", "./data/target.txt");

    @Test
    public void whenTestingStringToArray() {
        String[] res = conn.stringToArray("800;500;400;501");
        assertThat(res[0], is("800"));
        assertThat(res[1], is("500"));
        assertThat(res[2], is("400"));
        assertThat(res[3], is("501"));
    }

    @Test
    public void whenTestingReadStrings() {
        conn.readStrings();
        List<String[]> res = conn.getArrayofstringslist();
        assertThat(res.get(0)[0], is("100"));
        assertThat(res.get(0)[1], is("200"));
        assertThat(res.get(0)[2], is("300"));

        assertThat(res.get(1)[0], is("400"));
        assertThat(res.get(1)[1], is("500"));
        assertThat(res.get(1)[2], is("200"));

        assertThat(res.get(2)[0], is("600"));
        assertThat(res.get(2)[1], is("700"));
        assertThat(res.get(2)[2], is("800"));

        assertThat(res.get(3)[0], is("400"));
        assertThat(res.get(3)[1], is("200"));
        assertThat(res.get(3)[2], is("100"));

        assertThat(res.get(4)[0], is("900"));
        assertThat(res.get(4)[1], is("910"));
        assertThat(res.get(4)[2], is("920"));

        assertThat(res.get(5)[0], is("700"));
        assertThat(res.get(5)[1], is("1000"));
        assertThat(res.get(5)[2], is("1100"));
    }

    @Test
    public void whenTestingComparisionStrings() {
        String[] arr1 = {"100", "200", "300", "400", "500", "600"};
        String[] arr2 = {"700", "100", "400", "720", "740", "730"};
        String[] arr3 = {"700", "800", "900", "1000", "1100", "1220"};

        conn.comparisionStrings(arr1, arr2);
        assertTrue(conn.comparisionStrings(arr1, arr2));
        assertFalse(conn.comparisionStrings(arr1, arr3));
    }

    @Test
    public void whenTestingAccumulatingGroups() {
        conn.start();
        List<List<String[]>> res = conn.getGroups();

        assertThat(res.size(), is(3));
        assertThat(res.get(0).size(), is(3));
        assertThat(res.get(0).get(0)[0], is("100"));
        assertThat(res.get(0).get(0)[1], is("200"));
        assertThat(res.get(0).get(0)[2], is("300"));
        assertThat(res.get(0).get(1)[0], is("400"));
        assertThat(res.get(0).get(1)[1], is("500"));
        assertThat(res.get(0).get(1)[2], is("200"));
        assertThat(res.get(0).get(2)[0], is("400"));
        assertThat(res.get(0).get(2)[1], is("200"));
        assertThat(res.get(0).get(2)[2], is("100"));

        assertThat(res.get(1).size(), is(2));
        assertThat(res.get(1).get(0)[0], is("600"));
        assertThat(res.get(1).get(0)[1], is("700"));
        assertThat(res.get(1).get(0)[2], is("800"));
        assertThat(res.get(1).get(1)[0], is("700"));
        assertThat(res.get(1).get(1)[1], is("1000"));
        assertThat(res.get(1).get(1)[2], is("1100"));

        assertThat(res.get(2).size(), is(1));
        assertThat(res.get(2).get(0)[0], is("900"));
        assertThat(res.get(2).get(0)[1], is("910"));
        assertThat(res.get(2).get(0)[2], is("920"));
    }

    @Test
    public void whenTestingWriteGroups() throws IOException {
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