package com.java.book.concurrent._2._2._3;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/6/4 17:07
 */
public class TestInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("I'm interrupted");
                    break;
                }
                try {
                    System.out.println(Thread.currentThread().isInterrupted());
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().isInterrupted());
                } catch (InterruptedException e) {
                    System.out.println("interrupted by sleep()");
                    //设置中断状态
                    Thread.currentThread().interrupt();
                }
                Thread.yield();
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
