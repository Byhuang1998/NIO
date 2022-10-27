package com.byhuang.socket;

import java.io.*;
import java.net.*;
import java.util.stream.Stream;


/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/27 12:46
 * @description A Java program for a Client
 */

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = null;

        BufferedReader bufferedReader = null;

        DataOutputStream outputStream = null;

        try {
            socket = new Socket("127.0.0.1", 2000);
            System.out.println("Connected...");
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line = "";

        while (! "Over".equals(line)) {
            try {
                line = bufferedReader.readLine();
                outputStream.writeUTF(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            bufferedReader.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("client finished visiting...");
    }
}

