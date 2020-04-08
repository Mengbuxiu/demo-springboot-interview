package com.java.book.concurrent._3._1._1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alin
 * @version 1.0
 * @description // 重入锁
 * @date 2019/6/5 11:28
 */
public class ReenterLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            lock.lock();
            try {
                i++;//临界区资源
            }finally {
                lock.unlock();//若忘记释放，其他线程就没有机会访问临界区了
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock t = new ReenterLock();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
