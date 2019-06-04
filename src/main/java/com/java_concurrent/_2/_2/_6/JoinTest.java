package com.java_concurrent._2._2._6;

/**
 * @author Alin
 * @version 1.0
 * @description // join()阻塞当前线程，在这里也就是main线程，直到子线程执行完毕，join(time)是等待最大时间
 * @date 2019/6/4 19:11
 * join方法的本质还是 wait(0);
 */
public class JoinTest {
    private volatile static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (; i < 10000000; i++);
        });
        thread.start();
        //不使用join和sleep很有可能得到0
        //Thread.sleep(1);
        //thread.join();
        System.out.println(i);
    }
}
