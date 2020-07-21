package com.interview.demo.高级.多线程.等待通知;

/**
 *类说明：测试wait/notify/notifyAll
 */
public class TestWN {
    private static Express express = new Express(0,Express.CITY);

    /*检查里程数变化的线程,不满足条件，线程一直等待*/
    private static class CheckKm extends Thread{
        @Override
        public void run() {
        	express.waitKm();
        }
    }

    /*检查地点变化的线程,不满足条件，线程一直等待*/
    private static class CheckSite extends Thread{
        @Override
        public void run() {
        	express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<3;i++){//三个线程是为了增大notify通知不到某个线程的概率
            new CheckSite().start();
        }
        for(int i=0;i<3;i++){//里程数的变化
            new CheckKm().start();
        }

        Thread.sleep(1000);
//        ThreadUtil.printAllThreadInfo();
        express.changeKm();//快递km变化
        express.changeSite();//快递地点变化
//        ThreadUtil.printAllThreadInfo();
    }
}
