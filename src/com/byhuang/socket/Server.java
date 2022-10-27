package com.byhuang.socket;

import java.net.*;
import java.io.*;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/27 12:46
 * @description A Java program for a Server
 */

public class Server {

    public static void main(String[] args) throws IOException {

        final int PORT = 2000;

        Socket socket = null;

        ServerSocket server = null;

        DataInputStream inputStream = null;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started...");
            socket = server.accept();
            System.out.println("Client accepted...");
            inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while (! "Over".equals(line)) {
                try {
                    line = inputStream.readUTF();
                    System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            socket.close();
        }
    }
}

