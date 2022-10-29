package com.byhuang.buffer;

import java.nio.CharBuffer;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/29 20:48
 * @description TODO
 */
public class BufferDemo {

    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(20);
        String src = "CharBuffer test...";
        charBuffer.put(src, 0, src.length());
        charBuffer.flip();
        while (charBuffer.hasRemaining()) {
            char tem = (char)charBuffer.get();
            if (tem == ' ') {
                charBuffer.mark();
                continue;
            }
            System.out.print(tem);
        }
        charBuffer.reset();
        System.out.println(charBuffer.position());
    }
}
