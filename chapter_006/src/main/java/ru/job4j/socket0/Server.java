package ru.job4j.socket0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5000;
        try {
            ServerSocket servSocket = new ServerSocket(port);
            System.out.println("Ждем подключения к серверу");
            Socket socket = servSocket.accept();
            System.out.println("Подключиение состоялось");

            InputStream socketInputStream = socket.getInputStream();
            OutputStream socketOutputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInputStream);
            DataOutputStream out = new DataOutputStream(socketOutputStream);
            String string = null;
            while (true) {
                string = in.readUTF();
                System.out.println("Мы получили следующее сообщение:" + string);
                System.out.println("Отправка обратно");
                out.writeUTF(string);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
