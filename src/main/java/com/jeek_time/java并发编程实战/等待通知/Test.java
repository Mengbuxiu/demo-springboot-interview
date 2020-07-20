package com.jeek_time.java并发编程实战.等待通知;

import org.apache.commons.lang3.ThreadUtils;

public class Test {
    static Express express = new Express();

    private static class ChangeKm implements Runnable {

        @Override
        public void run() {
            try {
                express.waitKmGreatThan100();
            } catch (InterruptedException e) {
                System.out.println("km is greater than 100.");
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) throws InterruptedException {
        Runnable[] runs = new Runnable[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new ChangeKm();
        }
        for (Runnable run : runs) {
            new Thread(run).start();
        }
        Thread.sleep(2000);
        System.out.println("-------------------------------------");
        ThreadUtils.getAllThreads().forEach(thread -> System.out.println(thread.getName() +" -> "+thread.getState()));
        System.out.println("-------------------------------------");
        express.changeKM();
    }
}
