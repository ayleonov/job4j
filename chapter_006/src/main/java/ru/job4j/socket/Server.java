package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try (
                PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            String ask;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("Hello oracle".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                } else {
                    if (!ask.equals("exit")) {
                        out.println("I don't understand");
                    } else {
                        out.println("exit the program");
                    }
                }
            } while (!("exit".equals(ask)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (
                final Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
