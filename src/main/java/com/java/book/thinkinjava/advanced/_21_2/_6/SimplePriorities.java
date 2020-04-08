package com.java.book.thinkinjava.advanced._21_2._6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/5/20 11:35
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    //不被编译器所优化
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + Thread.currentThread().getPriority() + ": " + countDown;
    }

    @Override
    public void run() {
        //设置优先级,在run之前设置才有效
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (0 == i % 1000) {
                    Thread.yield();
                }
            }
            System.out.println("me: " + this);
            if (0 == --countDown) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
