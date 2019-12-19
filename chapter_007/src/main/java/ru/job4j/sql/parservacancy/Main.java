package ru.job4j.sql.parservacancy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Jsoup.connect("http://yandex.ru").get().title());
      /* // String url ="https://www.sql.ru/forum/job-offers";
        File htmlFile = new File("http://alekseyleonov.narod.ru");
        Document doc = Jsoup.parse(htmlFile, "UTF-8");
        String title = doc.title();
        System.out.println("Title : " + title);*/





    }


}
