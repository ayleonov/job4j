package ru.job4j.socket;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() {

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner console = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            out.println("Hello oracle");
            String str = in.readLine();

            do {

                while (str != null) {
                    str = console.nextLine();
                    System.out.println(str);
                    sb.append(str);
                }

            } while (!sb.toString().equals("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 5000)) {
            new Client(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
