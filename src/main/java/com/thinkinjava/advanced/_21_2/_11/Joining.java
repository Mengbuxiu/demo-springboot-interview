package com.thinkinjava.advanced._21_2._11;

public class Joining {
    public static void main(String[] args) {
        Sleeper
                //sleeper = new Sleeper("睡眠线程-1", 1500),
                grumpy = new Sleeper("睡眠线程-2", 1500);
               //new Joiner("Join线程-1", sleeper);
               new Joiner("Join线程-2", grumpy);
        grumpy.interrupt();
    }
}