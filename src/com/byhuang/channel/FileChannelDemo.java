package com.byhuang.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/26 20:49
 * @description TODO
 */
public class FileChannelDemo {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("G:\\testFile\\test01.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int read = channel.read(byteBuffer);
        while (read != -1) {
            System.out.println("read: " + read);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
            read = channel.read(byteBuffer);
        }
        randomAccessFile.close();
        System.out.println("\n" + "finish...");
    }
}
