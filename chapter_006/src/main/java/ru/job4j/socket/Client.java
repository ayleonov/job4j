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
            String str;
            do {
                out.println("Hello oracle");
                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
                while (!(str = console.nextLine()).isEmpty()) {
                    out.println();
                }

            } while (!str.equals("exit"));

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
