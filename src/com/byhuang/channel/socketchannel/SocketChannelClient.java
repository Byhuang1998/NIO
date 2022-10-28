package com.byhuang.channel.socketchannel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/28 17:19
 * @description TODO
 */
public class SocketChannelClient {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = null;
        SocketChannel client = null;
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        client = serverSocket.accept();

        RandomAccessFile randomAccessFile = new RandomAccessFile("G:\\testFile\\test02.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);

        while (client.read(byteBuffer) > 0) {
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
        }
        fileChannel.close();
        client.close();
        System.out.println("File received...");
    }
}
