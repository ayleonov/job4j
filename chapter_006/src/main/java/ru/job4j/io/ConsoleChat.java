package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * "Консольный чат."
 *
 * @author Aleksey Leonov.
 * верс.1.1.
 *
 * Изменения по отнош к верс.1.0 с доработками:
 * откорректировано однократное получение
 * списка автоответов).
 *
 * 12 Nov 2019.
 */
public class ConsoleChat {
    List<String> answers = new ArrayList<>();

    public void insertText() {
        boolean ifExit = false;
        int key = 0;
        readtemplates();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            new File("chapter_006/data/textconsole.txt").createNewFile();
            PrintWriter out = new PrintWriter(new FileWriter("chapter_006/data/textconsole.txt", true));
            //PrintWriter out = new PrintWriter(new FileWriter("./data/textconsole.txt", true));

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
                out.flush();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void readtemplates() {
        // try (BufferedReader br = new BufferedReader(new FileReader("./data/templates.txt"))) {
        try (BufferedReader br = new BufferedReader(new FileReader("chapter_006/data/templates.txt"))) {
            while (br.ready()) {
                answers.add(br.readLine());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String answer() {
        int numberCycles = 0;
        String res = "";
        boolean ifExit = false;
        while (!ifExit) {
            String insert = answers.get(numberCycles);
            numberCycles++;
            if (numberCycles >= (int) (20 * Math.random())) {
                res = insert;
                ifExit = true;
            }
        }
        return res;

    }

    public static void main(String[] args)  {
        new ConsoleChat().insertText();
    }
}

