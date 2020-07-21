package com.interview.demo.高级.多线程.等待通知;

/**
 * 类说明：快递实体类
 */
public class Express {
    public final static String CITY = "ShangHai";
    private int km;/*快递运输里程数*/
    private String site;/*快递到达地点*/
    private final Object obj = new Object();

    public Express() {
    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    /* 变化公里数，然后通知处于wait状态并需要处理公里数的线程进行业务处理*/
    public synchronized void changeKm() {
        this.km = 101;
        notifyAll();
        //其他的业务代码

    }

	/** throw IllegalMonitorStateException
	 * 官方解释：抛出该异常表明某一线程已经试图等待对象的监视器，或者试图通知其他正在等待对象的监视器，然而本身没有指定的监视器的线程。
	 * 也就是当前的线程不是此对象监视器的所有者。当前线程要锁定该对象之后，才能用锁定的对象执行这些方法，这里需要用到synchronized关键字，
	 * <b>锁定哪个对象就用哪个对象来执行notify(), notifyAll(),wait(), wait(long), wait(long, int)操作，
	 * 否则就会报IllegalMonitorStateException异常。</b>
	 *   <pre> {@code
	 *     public Class Test{
	 * 			public Object lock = new Object();
	 *  		public static void method（）{
	 *     			synchronized (lock) {
	 *     		 	//需要调用 lock.notify();
	 *     			}
	 *  		}
	 * 		}
     * 	}
	 * </pre>
	 synchronized (obj) {
	 this.site = "BeiJing";
	 notify();
	 }*/
    public synchronized void changeSite() {
		/* 变化地点，然后通知处于wait状态并需要处理地点的线程进行业务处理*/
        this.site = "BeiJing";
        notify();
    }

    public synchronized void waitKm() {
        while (this.km <= 100) {
            try {
                wait();
                System.out.println("check km thread[" + Thread.currentThread().getId()
                        + "] is be notifed.");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("the km is " + this.km + ",I will change db.");

    }

    public synchronized void waitSite() {
        while (CITY.equals(this.site)) {
            try {
                wait();
                System.out.println("check site thread[" + Thread.currentThread().getId()
                        + "] is be notifed.");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("the site is" + this.site + ",I will call user.");
    }
}
