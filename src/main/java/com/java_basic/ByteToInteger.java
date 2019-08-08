package com.java_basic;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

/**
 * @author Alin
 * @desc //Java中的Byte转为无符号的Integer
 *      https://blog.csdn.net/hfrujhv/article/details/83997753
 * @date 2019/8/8
 */

class ByteToInteger {
    @Test
    void testStream() {
        byte[] bytes = new byte[]{(byte)-42};
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        int result = in.read();
        System.out.println("无符号数: \t"+result);
        System.out.println("2进制bit位: \t"+Integer.toBinaryString(result));

    }
    @Test
    void test() {
//        int a = 11010110;
        byte[] bytes = new byte[]{(byte)11010110};
        System.out.println(bytes[0] & 0xff);
    }
}
