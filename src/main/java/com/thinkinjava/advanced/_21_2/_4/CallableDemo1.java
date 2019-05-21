package com.thinkinjava.advanced._21_2._4;

import com.thinkinjava.advanced._21_2._4.TaskWithResult;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Alin
 * @desc //线程执行完毕后为什么不会马上释放对象引用？【导致程序要过一会才会停止？】
 * @date 2019/5/20
 */
public class CallableDemo1 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> fs = exec.submit(new TaskWithResult(1));
        try {
            System.out.println(fs.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        if (fs.isDone()) {
            System.out.println("thread 1 is ok.");
        }
    }
}
