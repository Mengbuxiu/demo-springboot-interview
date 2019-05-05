package com.thinkinjava.basic._15_3.fibonacci;


import java.util.Iterator;

/**
 * @author Alin
 * @version 1.0
 * @description //
 * @date 2019/5/5 17:46
 * Q:在不修改源代码的情况下遍历Fibonacci?
 * A:使用适配器模式
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int n;

    public IterableFibonacci(int count){
        n = count;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (Integer i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }
}
