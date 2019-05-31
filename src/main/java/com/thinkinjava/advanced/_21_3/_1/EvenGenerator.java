package com.thinkinjava.advanced._21_3._1;

/**
 * @author Alin
 * @desc //注定会挂掉的程序，本机上测试，运行后就会cpu100%
 * @date 2019/5/25
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
