package com.java.book.concurrent._2._2._1;

/**
 * @author Alin
 * @desc // lambda + run thread
 * @date 2019/5/28
 * 先执行完主线程再执行子线程
 * currentThread: main is RUNNABLE...
 * currentThread: Thread-0 is RUNNABLE...
 */
public class StartAThread {

    public static void main(String[] args) {
        new Thread(StartAThread::code).start();
        code();
    }

    private static void code() {
        Thread thread = Thread.currentThread();
        System.out.println(String.format("currentThread: %s is %s...", thread.getName(), thread.getState()));
    }
}
