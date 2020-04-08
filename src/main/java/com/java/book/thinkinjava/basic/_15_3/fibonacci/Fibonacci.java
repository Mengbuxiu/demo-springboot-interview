package com.java.book.thinkinjava.basic._15_3.fibonacci;

import com.java.book.thinkinjava.basic._15_3.interf.Generator;

/**
 * @author Alin
 * @version 1.0
 * @description // 生成斐波那契数列
 * @date 2019/5/5 17:36
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;
    @Override
    public Integer next() {
        return fibo(count++);
    }

    private Integer fibo(int n) {
        if (2 > n) {
            return 1;
        }
        return fibo(n - 2) + fibo( n - 1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.print(gen.next() + " ");
        }
    }
}
