package com.interview.demo.高级.集合;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * @author zhenglin
 *  
 * @desc
 * @date 2021/6/25 4:34 下午
 */
public class TestHashMap {
    public static void main(String[] args) {
        int i = tableSizeFor(10);
        System.out.println(i);

    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n = n | (n >>> 1);
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
