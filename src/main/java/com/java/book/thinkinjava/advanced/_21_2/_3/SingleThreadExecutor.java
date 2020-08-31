package com.java.book.thinkinjava.advanced._21_2._3;

import com.java.book.thinkinjava.advanced._21_2._1.LiftOff;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @author Alin
 * @desc //使用同一个线程，并排队
 * @date 2019/5/20
 */
public class SingleThreadExecutor {
    private static final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("1111").build());
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start");

        exec.submit(() -> {
            try {
                Thread.sleep(300 * 1000);
                System.out.println("sub over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        System.out.println("submit.get() = " + submit.get());
//        exec.shutdown();
        System.out.println("main thread over");
    }
}
