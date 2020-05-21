package com.jeek_time.juc;


import java.util.concurrent.CountDownLatch;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/6/27 11:53
 */
public class TestSafe {
    public static void main(String[] args) {
        SafeWM safe = new SafeWM();
        safe.setLowwer(2);
        safe.setUpper(10);
        CountDownLatch latch = new CountDownLatch(2);
        Thread thread1 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            safe.setLowwer(7);
        });
        Thread thread2 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            safe.setUpper(5);
        });

        thread1.start();
        latch.countDown();
        thread2.start();
        latch.countDown();
        if (safe.getLower() > safe.getUpper()) {
            System.out.println("------------->  " + safe);
        }
    }
}
