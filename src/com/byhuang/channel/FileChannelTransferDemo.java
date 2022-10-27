package com.byhuang.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/27 10:47
 * @description Transfer data between channels
 */
public class FileChannelTransferDemo {

    public static void main(String[] args) throws IOException {
        RandomAccessFile fromAccessFile = new RandomAccessFile("G:\\testFile\\test01.txt", "rw");
        RandomAccessFile toAccessFile = new RandomAccessFile("G:\\testFile\\test02.txt", "rw");
        FileChannel fromChannel = fromAccessFile.getChannel();
        FileChannel toChannel = toAccessFile.getChannel();
        long position = 0;
        long fromSize = fromChannel.size();
        long toSize = fromChannel.size();
//        toChannel.transferFrom(fromChannel, position, fromSize);
        fromChannel.transferTo(position, toSize, toChannel);
        fromChannel.close();
        toChannel.close();
    }
}
