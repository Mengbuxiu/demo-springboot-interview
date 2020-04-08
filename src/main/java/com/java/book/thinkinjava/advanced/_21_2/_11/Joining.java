package com.java.book.thinkinjava.advanced._21_2._11;

public class Joining {
    public static void main(String[] args) {
        Sleeper
                //sleeper = new Sleeper("睡眠线程-1", 1500),
                grumpy = new Sleeper("睡眠线程-2", 15000);
               //new Joiner("Join线程-1", sleeper);
               //new Joiner("Join线程-2", grumpy);
        /**
         * If this thread is blocked in an invocation of the
         * wait(),join(),sleep
         * then its interrupt status will be cleared and it
         * will receive an {@link InterruptedException}.
         */
        grumpy.interrupt();
    }
}