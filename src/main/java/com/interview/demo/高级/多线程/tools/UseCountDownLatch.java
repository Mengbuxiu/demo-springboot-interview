package com.interview.demo.高级.多线程.tools;

import com.interview.demo.util.SleepTools;

import java.util.concurrent.CountDownLatch;

/**
 *类说明：演示CountDownLatch，有5个初始化的线程，6个扣除点，
 *扣除完毕以后，主线程和业务线程才能继续自己的工作
 */
public class UseCountDownLatch {
	
	static CountDownLatch latch = new CountDownLatch(6);

	//初始化线程(只有一步，有4个)
    private static class InitThread  implements Runnable{

        @Override
        public void run() {
        	System.out.println("Init Thread_"+Thread.currentThread().getId()
        			+" ready init work......");
        	latch.countDown();//初始化线程完成工作了，countDown方法只扣减一次；
            	System.out.println("\tThread_"+Thread.currentThread().getId()
            			+" ........continue do its work");
        }
    }
    
    //业务线程，启动后等待，等其他线程执行countDown()完成继续执行
    private static class BusiThread implements Runnable{

        @Override
        public void run() {
        	try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            	System.out.println("Busi Thread_"+Thread.currentThread().getId()
            			+" do business-----");
        }
    }

    public static void main(String[] args) throws InterruptedException {
    	//单独的初始化线程,初始化分为2步，需要扣减两次
//        new Thread(() -> {
//            SleepTools.ms(1);
//            System.out.println("Thread_"+Thread.currentThread().getId()
//                    +" ready init work step 1st......");
//            latch.countDown();//每完成一步初始化工作，扣减一次
//            System.out.println("begin step 2nd.......");
//            SleepTools.ms(1);
//            System.out.println("Thread_"+Thread.currentThread().getId()
//                    +" ready init work step 2nd......");
//            latch.countDown();//每完成一步初始化工作，扣减一次
//        }).start();

        new Thread(new BusiThread()).start();

        for(int i=0;i<=3;i++){
            Thread thread = new Thread(new InitThread());
            thread.start();
        }

        latch.await();
        System.out.println("Main do ites work........");
    }
}
