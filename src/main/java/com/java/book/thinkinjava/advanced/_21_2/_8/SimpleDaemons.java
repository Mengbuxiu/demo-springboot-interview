package com.java.book.thinkinjava.advanced._21_2._8;

import java.util.concurrent.TimeUnit;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/5/20 13:48
 * 后台线程[守护线程],是指在程序运行的时候在后台提供一种通用服务的线程，并且这种线程不属于不可获取的部分。
 * 当所有非后台线程结束时，程序即终止，同时杀死进程中的所以后台线程
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemons = new Thread(new SimpleDaemons());
            daemons.setDaemon(true);
            daemons.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
