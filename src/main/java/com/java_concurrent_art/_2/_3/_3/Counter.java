package com.java_concurrent_art._2._3._3;

import com.interview.demo.util.DateUtil;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alin
 * @version 1.0
 * @description // CAS计数器
 * @date 2019/6/5 19:52
 * CAS存在的问题，ABA、循环时间长开销大、只能保证一个共享变量的原子操作
 */
public class Counter {
    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        ArrayList<Thread> ts = new ArrayList<>(60);
        long start = DateUtil.getClockMillis();
        for (int j = 0; j < 100; j++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    cas.count();
                    cas.safeCount();
                }
            });
            ts.add(thread);
            thread.start();
        }
        //等待所有线程执行完成
        ts.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("非线程安全计数结果：" + cas.i);
        System.out.println("线程安全计数结果：" + cas.atomicI.get());
        System.out.println(DateUtil.getClockMillis() - start);
    }

    /**
     * CAS线程安全计数
     */
    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    /**
     * 非线程安全计数
     */
    private void count() {
        i++;
    }
}
