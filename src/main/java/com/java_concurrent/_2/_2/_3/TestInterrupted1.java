package com.java_concurrent._2._2._3;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/6/4 17:07
 */
public class TestInterrupted1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("I'm interrupted");
                }
                try {
                    System.out.println(Thread.currentThread().isInterrupted());
                    System.out.println(Thread.interrupted());
                    System.out.println(Thread.currentThread().isInterrupted());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("interrupted by sleep()");
                    //设置中断状态
                    Thread.currentThread().interrupt();
                }
        });
        thread.start();
    }
}
