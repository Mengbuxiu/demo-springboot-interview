package com.java.book.concurrent._2._1;

/**
 * @author Alin
 * @desc //TODO
 * @date 2019/5/28
 * 一个线程共有六种状态，分别是
 *  NEW,RUNNABLE,BLOCKED,WAIT,TIMED_WAITING,TERMINATED
 */
public class StateThread extends Thread {
    @Override
    public void run() {
        System.out.println(getState());
    }
    StateThread(){
        System.out.println(getState());
    }
}
