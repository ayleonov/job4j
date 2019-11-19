package ru.job4j.otherversions.socket0;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        int servPort = 5000;
        String ipAddress = "127.0.0.1";
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            System.out.println("Подключаемся к серверу:" + servPort);
            Socket socket = new Socket(inetAddress, servPort);
            InputStream socketInputStream = socket.getInputStream();
            OutputStream socketOutputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInputStream);
            DataOutputStream out = new DataOutputStream(socketOutputStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = null;
            System.out.println("Введите фразу для передачи серверу:");
            while (true) {
                string = reader.readLine();
                out.writeUTF(string);
                out.flush();
                string = in.readUTF();
                System.out.println("Сервер прислал в ответ:" + string);
                System.out.println("Введите фразу для отправки на сервер:");
            }



















        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
