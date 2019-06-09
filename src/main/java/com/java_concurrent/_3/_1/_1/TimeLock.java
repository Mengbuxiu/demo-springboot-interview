package com.java_concurrent._3._1._1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alin
 * @version 1.0
 * @description // 线程状态
 * @date 2019/6/5 17:14
 */
public class TimeLock {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            private ReentrantLock lock = new ReentrantLock();
            @Override
            public void run() {
                try {
                    if (lock.tryLock(5, TimeUnit.SECONDS)) {
                        System.out.println(Thread.currentThread().getName()+
                                " : get lock");
                        Thread.sleep(6000);
                    } else {
                        System.out.println(Thread.currentThread().getName()+
                                " : can not get lock");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //isHeldByCurrentThread 当前线程获取锁返回true
                    if (lock.isHeldByCurrentThread()) {
                        lock.unlock();
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable,"线程-1");
        Thread t2 = new Thread(runnable,"线程-2");
        // new 线程代表新建状态，同一起跑线，start代表就绪状态，获得cpu时间片后运行run方法代表运行状态
        t2.start();
        t1.start();
    }
}
