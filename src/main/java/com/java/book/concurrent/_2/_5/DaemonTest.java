package com.java.book.concurrent._2._5;

/**
 * @author Alin
 * @version 1.0
 * @description // 守护线程是相对于用户线程的，用户线程在这里对应main线程，
 *  thread.setDaemon(true) main线程结束后守护线程随之结束
 * @date 2019/6/4 20:19
 * 守护线程，字面意思
 */
public class DaemonTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("I'm alive!");
            }
        });
        //thread.setDaemon(true); 不加守护线程程序永远无法退出
        thread.start();
        Thread.sleep(2000);
    }
}
