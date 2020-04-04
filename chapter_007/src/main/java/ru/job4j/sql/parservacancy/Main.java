package ru.job4j.sql.parservacancy;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        //String sitenamelink = "https://www.sql.ru/forum/job-offers";
        String sitenamelink = "http://yandex.ru";

        Set<String> receivedURL = new HashSet();
        String urlForSearch = "https://www.sql.ru/forum/job-offers/";
        for (int i = 0; i < 20; i++) {
            String urlTotal = urlForSearch + i;

            Document doc = Jsoup.connect(urlTotal).get();
            //  Document doc = Jsoup.connect("http://yandex.ru").get();

            //Elements links = doc.select("java ");
            Elements links = doc.select("a[href]");

            for (Element link : links) {
                String nameVac = link.text();
                String nameVacWS = nameVac.replace(" ", "");
                //boolean a = (nameVacWS.split("Java/JavaScript")).length >1;
                boolean a = false;
                //if (linkText.contains("java ") || linkText.contains("Java ")){
                if ((((nameVacWS.split("Java")).length > 1) && (!((nameVacWS.split("JavaScript")).length > 1)) && (!(nameVacWS.startsWith("JavaScript"))) && (!(nameVacWS.endsWith("JavaScript")))) || a) {
                    String linkVac = link.attr("href");
                    System.out.println(nameVac);
                    System.out.println(linkVac);
                    //}
                    //System.out.println(link.attr("href"));
                    //System.out.println(link.text())
                    //link.attr(class,msgBody);
                }
            }
        }

      /* // String url ="https://www.sql.ru/forum/job-offers";
        File htmlFile = new File("http://alekseyleonov.narod.ru");
        Document doc = Jsoup.parse(htmlFile, "UTF-8");
        String title = doc.title();
        System.out.println("Title : " + title);*/


    }
}
