package com.byhuang.iostream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/27 15:26
 * @description TODO
 */
public class OutputStreamDemo {

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("G:\\testFile\\test02.txt");
        String data = "this sentence will be written into test02.txt";
        outputStream.write(data.getBytes());
        outputStream.close();
        System.out.println("outputStream finished writing");
    }
}
