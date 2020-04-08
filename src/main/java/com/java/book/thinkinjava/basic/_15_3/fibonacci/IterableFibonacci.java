package com.java.book.thinkinjava.basic._15_3.fibonacci;


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

    /**
     * @param count 边界值
     */
    public IterableFibonacci(int count){
        n = count;
    }

    /**
     * implements Iterable<Integer> override iterator()
     * 则 会有匿名内部类的实现，必须重写hasNext(),next()方法，
     * 因为Iterator是个接口
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            /**
             * @return 判断边界值
             */
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                //生成对外部类对象的引用，可以使用外部类.this
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
