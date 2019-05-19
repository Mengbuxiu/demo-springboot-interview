package com.thinkinjava.advanced._21_2;

/**
 * @author Alin
 * @desc //线程驱动任务，这个是描述任务的实现，显示发射之前的倒计时
 * @date 2019/5/19
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    /**
     * 区分任务的多个实例
     */
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff!") + ").";
    }

    /**
     * 这个方法并无特殊之处，
     * 要实现线程行为，你必须显式地将一个任务附着到线程上
     */
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            /**
             * 原书描述大意：我完成我的任务了，你(cpu)可以切换去做其他任务了
             * */
            Thread.yield();
        }
    }
}
