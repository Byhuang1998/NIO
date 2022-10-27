package com.byhuang.iostream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/27 15:20
 * @description TODO
 */
public class InputStreamDemo {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("G:\\testFile\\test01.txt");
        int i;
        while ((i = inputStream.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println("\n" + "inputStream finished reading ...");
        inputStream.close();
    }
}
