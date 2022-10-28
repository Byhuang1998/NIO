package com.byhuang.channel.datagramchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/28 15:28
 * @description TODO
 */
public class DatagramChannelServer {

    public static void main(String[] args) throws IOException {
        // Initial a DatagramChannel with open() method.
        DatagramChannel server = DatagramChannel.open();
        // State a local address
        InetSocketAddress localAddress = new InetSocketAddress("127.0.0.1", 8989);
        // Binds the channel's socket to a local address.
        server.bind(localAddress);
        System.out.println("Server started: " + localAddress);
        // State a ByteBuffer to receive datagram from remote address.
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // Receive datagram from remote address then return the remote address.
        SocketAddress remoteAddress = server.receive(byteBuffer);
        byteBuffer.flip();
        int limit = byteBuffer.limit();
        byte[] bytes = new byte[limit];
        // Copy buffer into array of bytes
        byteBuffer.get(bytes, 0, limit);
        String msg = new String(bytes);
        System.out.println("Client at " + remoteAddress + "sent: " + msg);
        server.send(byteBuffer, remoteAddress);
        server.close();
    }
}
