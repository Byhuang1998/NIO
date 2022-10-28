package com.byhuang.channel.datagramchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/28 16:34
 * @description TODO
 */
public class DatagramChannelClient {

    public static void main(String[] args) throws IOException {
        DatagramChannel client = DatagramChannel.open();

        ByteBuffer byteBuffer = ByteBuffer.wrap("hello world".getBytes());
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", 8989);
        client.send(byteBuffer, serverAddress);
        byteBuffer.clear();
        client.receive(byteBuffer);
        byteBuffer.flip();
        int limit = byteBuffer.limit();
        byte[] response = new byte[limit];
        byteBuffer.get(response, 0, limit);
        System.out.println(Arrays.toString(response));
        client.close();
    }
}
