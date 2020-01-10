package com.interview.demo.nio;

import lombok.SneakyThrows;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Alin
 * @version 1.0
 * @description // MappedByteBuffer将较大的文件映射到内存中。
 * @date 2020/1/10 10:35
 */
public class NIOMappedByteBufferDemo {
    @SneakyThrows
    public static void main(String[] args) {
        int length = 1024 * 1024 * 10;
        final MappedByteBuffer out = new RandomAccessFile("Z:\\111.mp4", "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            System.out.println((char) out.get());
        }
    }
}
//a 97 b 98 c 99 d 100 e 101 f 102