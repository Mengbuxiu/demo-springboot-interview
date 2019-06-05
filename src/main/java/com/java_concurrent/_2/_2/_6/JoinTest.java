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
        //不使用join()很有可能得到0
        //这行代码的意思是让子线程活动10ms，然后死亡
        //join(0)代表一直活动直到子线程死亡
        thread.join(10);
        //按照官方文档的意思是：等待这个线程死亡
        //换句话说，只有这个线程死亡了，主线程才能继续往下执行，
        //所以，join在此是阻塞了主线程，来执行子线程
        //thread.join();
        System.out.println(i);
    }
}
