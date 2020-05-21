package com.jeek_time.java并发编程实战.二.happensbefore;

/**
 * 测试happens-before中的start规则
 * 主线程中start子线程B，在start B线程时可看到主线程对共享变量的操作， 0 -> 1
 */
class TestStart{
    static int i=0;
    public static void main(String[] args) {
        i=1;
        final Thread subThreadB = new Thread(() ->{
            System.out.println(TestStart.i);
        });
        subThreadB.setName("子线程B");
        subThreadB.start();
    }
}

