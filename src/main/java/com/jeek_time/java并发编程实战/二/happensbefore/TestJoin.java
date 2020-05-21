package com.jeek_time.java并发编程实战.二.happensbefore;

import lombok.SneakyThrows;

/**
 * 测试happens-before中的join规则
 * 指主线程等待子线程 B 完成（主线程通过调用子线程 B 的 join() 方法实现），
 * 当子线程 B 完成后（主线程中 join() 方法返回），主线程能够看到子线程B的操作(共享变量)
 */
public class TestJoin{
    static int i = 0;
    @SneakyThrows
    public static void main(String[] args) {
        final Thread subThreadB = new Thread(() ->{
            TestJoin.i = 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        subThreadB.setName("子线程B");
        subThreadB.start();

        System.out.println("返回前：" + TestJoin.i);
        subThreadB.join();
        System.out.println("返回后：" + TestJoin.i);
    }

}
