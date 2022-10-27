package com.byhuang.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/27 10:08
 * @description TODO
 */
public class FileChannelWriteDemo {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("G:\\testFile\\test01.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        String data = "aaa";
        byteBuffer.clear();
        byteBuffer.put(data.getBytes());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            channel.write(byteBuffer);
        }
        channel.close();
    }
}
