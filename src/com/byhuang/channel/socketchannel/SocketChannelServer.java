package com.byhuang.channel.socketchannel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/28 17:20
 * @description TODO
 */
public class SocketChannelServer {

    private static ByteBuffer byteBuffer;

    public static void main(String[] args) throws IOException {
        SocketChannel server = SocketChannel.open();
        server.connect(new InetSocketAddress("localhost", 9000));
        RandomAccessFile randomAccessFile = new RandomAccessFile("G:\\testFile\\test01.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        byteBuffer = ByteBuffer.allocate(100);
        while (fileChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            server.write(byteBuffer);
            byteBuffer.clear();
        }
        fileChannel.close();
        server.close();
        System.out.println("File sent...");
    }
}
