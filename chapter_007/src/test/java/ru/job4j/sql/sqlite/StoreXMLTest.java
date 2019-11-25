package ru.job4j.sql.sqlite;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import ru.job4j.sql.sqlite.XmlUsage.Field;

public class StoreXMLTest {
    private StoreSQL storeSQL;
    private StoreXML storeXML;
    private List<String> res;


    @Before
    public void beforeTest() {
        Config config = new Config();
        config.init();
        storeSQL = new StoreSQL(config);
        File file = new File("C:/projects/sqlite/db/test.db");
        storeSQL.createNewDataBase("test.db");
        File fileTarget = new File("./data/first.xml");
        storeSQL.generate(6);
        storeXML = new StoreXML(fileTarget);
    }

    @Test
    public void whenTestingMarshallingInXML() throws IOException {
        //File fileTarget = new File("./data/first.xml");
       // storeXML = new StoreXML(fileTarget);
        res = new ArrayList<>();
        prepare();
        BufferedReader br = new BufferedReader(new FileReader("./data/first.xml"));
        while (br.ready()) {
            res.add(br.readLine());
        }
        br.close();

        assertThat(res.get(1), is("<entry>"));
        for (int i = 0; i < 6; i++) {
            assertThat(res.get(3*i + 2).trim(), is("<values>"));
            assertThat(res.get(3*i + 3).trim(), is("<value>" + (i + 1) + "</value>"));
            assertThat(res.get(3*i + 4).trim(), is("</values>"));
        }
        assertThat(res.get(20), is("</entry>"));
    }

    @Test
    public void whenTestingMarshallingInConsole() throws IOException {

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final PrintStream stdout = System.out;
        System.setOut(new PrintStream(out));
        prepare();
        assertThat(out.toString(), is(
                new StringBuilder()
                        .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                        .append("<entry>\n")
                        .append("    <values>\n")
                        .append("        <value>1</value>\n")
                        .append("    </values>\n")
                        .append("    <values>\n")
                        .append("        <value>2</value>\n")
                        .append("    </values>\n")
                        .append("    <values>\n")
                        .append("        <value>3</value>\n")
                        .append("    </values>\n")
                        .append("    <values>\n")
                        .append("        <value>4</value>\n")
                        .append("    </values>\n")
                        .append("    <values>\n")
                        .append("        <value>5</value>\n")
                        .append("    </values>\n")
                        .append("    <values>\n")
                        .append("        <value>6</value>\n")
                        .append("    </values>\n")
                        .append("</entry>\n").toString()
        ));
        System.setOut(stdout);
    }
    
    public void prepare()  {
        List<Field> load = storeSQL.load();
        storeXML.save(load);
        List<String> res = new ArrayList<>();
    }
}