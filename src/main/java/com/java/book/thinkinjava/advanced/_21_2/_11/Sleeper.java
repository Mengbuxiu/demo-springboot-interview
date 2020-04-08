package com.java.book.thinkinjava.advanced._21_2._11;

/**
 * @author Alin
 * @desc //睡眠指定时间
 * @date 2019/5/22
 */
public class Sleeper extends Thread {
    /**
     * 睡眠时间
     */
    private int duration;

    /**
     * 调用此构造器同时启动线程
     * @param name 线程名
     * @param sleepTime 睡眠时间
     */
    public Sleeper(String name, int sleepTime ) {
        super(name);
        duration = sleepTime;
        start();
        //System.out.println(name + " 线程启动");
    }

    @Override
    public void run() {
        try {
            //System.out.println(getName() + " isAlive ? " + isAlive());
            System.out.println(getName() + " " + this.getState().name());
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(String.format("%s was interrupted.\tisInterrupted(): %s", getName(), isInterrupted()));
        }
        System.out.println(getName() + " has awakened");
    }
}

/**
 * 线程加入
 */
class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
        System.out.println(name + " 线程启动");
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " " + this.getState().name());
            sleeper.join();
            System.out.println(getName() + " " + this.getState().name());
        } catch (InterruptedException e) {
            System.out.println(getName()+"was Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

