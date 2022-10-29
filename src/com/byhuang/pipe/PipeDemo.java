package com.byhuang.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/29 20:16
 * @description TODO
 */
public class PipeDemo {

    public static void main(String[] args) throws IOException {

        // An instance of Pipe is created.
        Pipe pipe = Pipe.open();
        // Gets the pipe's sink channel and source channel.
        Pipe.SinkChannel sink = pipe.sink();
        Pipe.SourceChannel source = pipe.source();

        String data = "pipe testing...";
        ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
        while (buffer.hasRemaining()) {
            sink.write(buffer);
        }
        // Set limit = position, position = 0, mark = -1
        buffer.flip();
        while (source.read(buffer) > 0) {
            buffer.flip();
            // method of hasRemaining returns position < limit ?
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
        }


    }
}
