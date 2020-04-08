package com.java.book.concurrent._3._1._1;

import lombok.NoArgsConstructor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alin
 * @version 1.0
 * @description // 锁中断 解救 死锁 示例
 * @date 2019/6/5 15:16
 * Thread-1占用lock1，Thread-2占用lock2，此时thread-1想去占用 lock2，而thread-2又想占用lock1，
 * 但是它俩都拿不到各自想要的锁，互相等待，则形成死锁
 */
@NoArgsConstructor
public class IntLock implements Runnable{
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private int lock;

    private IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        try {
            if (1 == lock) {
                    lock1.lockInterruptibly();
                    Thread.sleep(500);
                try {
                    lock2.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                    lock2.lockInterruptibly();//在等待锁时，可以响应中断
                    Thread.sleep(500);
                    try {
                        lock1.lockInterruptibly();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " 线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }
}
