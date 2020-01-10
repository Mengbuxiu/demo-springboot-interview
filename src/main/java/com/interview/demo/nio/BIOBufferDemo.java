package com.interview.demo.nio;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Alin
 * @version 1.0
 * @description // NIO
 * @date 2020/1/9 15:28
 */
public class BIOBufferDemo {
    @SneakyThrows
    public static void main(String[] args) {
        int bufferSize = 1024;
        FileChannel src = new FileInputStream("Z:\\vue.txt").getChannel();
        FileChannel dest = new FileOutputStream("Z:\\vue2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        while (src.read(buffer) != -1) {
            // 切换读写模式
            buffer.flip();
            // 写入到dest
            dest.write(buffer);
            // 清空缓存空间
            buffer.clear();
        }
        dest.close();
        src.close();
    }
}
