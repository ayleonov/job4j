package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * "Консольный чат."
 *
 * @author Aleksey Leonov.
 * верс.2.1.
 * Изменения по сравнению с верс 2.0.
 * введено однократное получение текста-ответов.
 *
 * 12 Nov 2019.
 */
public class ConsoleChat3 {
    private List<String> answers = new ArrayList<>();
    /**
     * Вводит данные с консоли в режиме работе с консоли
     * или вводит вносимые данные из Тест-класса при тестировании.
     * <p>
     * key характер текущей работы программы, равен:
     * 0 - в режиме ввод-ответ;
     * 1 - в режиме ввод;
     * 2 - идет завершение программы.
     * <p>
     * insertPosition - текущий индекс списка подаваемых значения
     * в тестировочном режиме.
     * <p>
     * время написания строк в тестировочном режиме не имеет смысла
     * в связи с быстротой операций, все строки будут написаны одновременно.
     *
     * @param insert dates for testing in test mode
     * @param mode   number of mode (receive with dates in test mode).
     * @throws IOException
     */
    public void insertText(List<String> insert, int mode) throws IOException {


        boolean ifExit = false;
        int key = 0;
        int insertPosition = 0;
        readtemplates();
        /** Чтобы принять номер режима поступающего с данными тестировочного режима
         *  и установка номера режима при работе с консолью
         *  вводится следующее условие.
         *  (введена на случай ошибки ввода при запуске через точку входа в класс)
         */
        if (mode != 2) {
            mode = 1;
        }

        /** Режимы:
         *  1. Ввод через консоль (mode = 1);
         *  2. Режим тестирования (ввод через тест-класс) (mode = 2).
         */

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            File file = new File("./data/textconsole.log");
            //PrintWriter out = new PrintWriter(new FileWriter("chapter_006/data/textconsole.log", true));
            PrintWriter out = new PrintWriter(new FileWriter(file, false));
            String answer = answer();
            out.println("================================================");
            out.println("Начало сеанса: " + new Date());
            while (!ifExit) {
                String text = "";

                if (mode == 1) {
                    text = br.readLine();
                } else {
                    text = insert.get(insertPosition++);
                }


                out.println(String.format("%s: %s", new Date(), text));
                System.out.println(String.format("%s: %s", new Date(), text));

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

                    Date currentDate = new Date();
                    out.println(String.format("%s: %s", currentDate, answer));
                    System.out.println(String.format("%s: %s", currentDate, answer));
                }
                if (insertPosition == insert.size()) {
                    System.out.println("Ряд тестовых данных завершен. Программа завершается");
                    ifExit = true;
                }
                out.flush();
            }

            out.println("Конец сеанса: " + new Date());
            out.println("================================================");



        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void readtemplates() {{
             try (BufferedReader br = new BufferedReader(new FileReader("./data/templates.txt"))) {
            //try (BufferedReader br = new BufferedReader(new FileReader("chapter_006/data/templates.txt"))) {
                while (br.ready()) {
                    answers.add(br.readLine());
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

    }

    /**
     * Выбирает фразу из заданных в текстовом файле.
     *
     * @return рандомная фраза из текстового файла.
     */

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


    /**
     * Точка входа в программу при режиме работы с консолью.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new ConsoleChat3().insertText(null, 1);
    }
}
