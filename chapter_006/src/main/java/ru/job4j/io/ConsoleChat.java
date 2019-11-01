package ru.job4j.io;

import java.io.*;
import java.util.Date;

public class ConsoleChat {

    public void insertText() throws IOException {
        boolean ifExit = false;
        int key = 0;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new FileWriter("chapter_006/data/textconsole.log", true));
        PrintWriter out = new PrintWriter(new FileWriter("./data/textconsole.log", true));
        while (!ifExit) {
            String text = br.readLine();

            out.println(String.format("%s: %s", new Date(), text));
            if (text.equals("закончить")) {
                key = 2;
                ifExit = true;
            }
            if (text.equals("стоп")) {
                key = 1;
            }
            if ((text.equals("продолжить"))) {
                key = 0;
            }
            if (key == 0) {
                String answer = answer();
                Date currentDate = new Date();
                out.println(String.format("%s: %s", currentDate, answer));
                System.out.println(String.format("%s: %s", currentDate, answer));
            }
        }
        br.close();
        out.close();
    }

    public String answer() throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("./data/templates.txt"));
        //BufferedReader buffRead = new BufferedReader(new FileReader("chapter_006/data/templates.txt"));
        int numberCycles = 0;
        String res = "";
        boolean ifExit = false;
        while (!ifExit) {
            numberCycles++;
            String insert = buffRead.readLine();
            if (numberCycles >= (int) (20 * Math.random())) {
                res = insert;
                ifExit = true;
            }
        }
        buffRead.close();
        return res;

    }

    public static void main(String[] args) throws IOException {
        new ConsoleChat().insertText();
    }
}
