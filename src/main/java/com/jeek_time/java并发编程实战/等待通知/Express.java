package com.jeek_time.java并发编程实战.等待通知;

public class Express {
    private int km = 50;

    public synchronized void changeKM() {
        this.km = 999;
        notifyAll();
        System.out.println("km is change to 999");
    }

    public synchronized void waitKmGreatThan100() throws InterruptedException {
        final Thread thread = Thread.currentThread();
        while (this.km <= 100) {
            // 此处只会被打印一次
            /*  因为他们都在waiting状态
                Thread-0 -> WAITING
                Thread-1 -> WAITING
                Thread-2 -> WAITING
             */
            System.out.println("km['" + this.km + "'] 不满足条件 , name:" + thread.getName() + ",state: " + thread.getState());
            wait();
            System.out.println("\twaiting状态转换到runnable");
        }
        System.out.println("km['" + this.km + "'] ------------------满足条件 , name:" + thread.getName() + ", state: "
                + thread.getState());
    }
}
