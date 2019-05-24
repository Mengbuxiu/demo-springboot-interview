package com.thinkinjava.advanced._21_3._1;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/5/24 21:07
 */
public abstract class IntGenerator {
    //boolean 变量是原子性的，赋值和返回值时不会中断，因此也没有中间状态
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
