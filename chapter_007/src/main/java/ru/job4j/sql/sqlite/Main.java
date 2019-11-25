package ru.job4j.sql.sqlite;

import java.io.File;
import java.util.List;
import ru.job4j.sql.sqlite.XmlUsage.Field;

public class Main {
    public static void main(String[] args)  {
        Config config = new Config();
        config.init();
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.createNewDataBase("test.db");
        storeSQL.generate(12);
        File fileTarget = new File("./data/first.xml");
        //if (!fileTarget.exists()) {
         //   fileTarget.createNewFile();
        //}
        StoreXML storeXML = new StoreXML(fileTarget);
        List<Field> a = storeSQL.load();
        System.out.println(a.size());
        storeXML.save(storeSQL.load());
    }
}
