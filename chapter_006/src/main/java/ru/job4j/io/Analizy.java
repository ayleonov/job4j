package ru.job4j.io;

import java.io.*;
import java.util.Date;

public class Analizy {
    StringBuilder cache = new StringBuilder();

    public void unavailable(String source, String target) {
        int key = 0;
        String dateStart = "";
        String dateFinish = "";

        try
                (BufferedReader br = new BufferedReader(new FileReader(source));
                 PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            while (br.ready()) {
                String str = br.readLine().trim();
                if (!str.isEmpty() && !str.startsWith("//") && !str.startsWith("##")) {
                    if (((str.substring(0, 3).equals("400")) || (str.substring(0, 3).equals("500"))) && key == 0) {
                        if (key == 0) {
                            dateStart = str.substring(4, 12);
                            dateFinish = "";
                        }
                        key++;
                    }
                    if (!(str.substring(0, 3).equals("400")) && !(str.substring(0, 3).equals("500"))) {
                        dateFinish = str.substring(4, 12);
                    }
                    if (!dateStart.equals("") && !dateFinish.equals("")) {
                        cache.append(String.format("%s %s", dateStart, dateFinish)).append(System.lineSeparator());
                        key = 0;
                    }

                }
            }
            writeresults(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeresults(String target) {
        try (
                PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(cache.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}
