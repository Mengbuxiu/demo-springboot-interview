package com.thinkinjava.advanced._21_3._1;

/**
 * @author Alin
 * @desc //TODO
 * @date 2019/5/26
 */
public class SynchronziedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronziedEvenGenerator());
    }
}
