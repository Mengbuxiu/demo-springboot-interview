package com.interview.demo.exception.transfer;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/5/21 19:05
 */
public class A {
    public static void a() throws RuntimeException{
        test();
        //if (1/0 == 0);
           // throw new  RuntimeException("error!");
    }

    private static void test() {
        if (1/0 == 0)
            throw new  RuntimeException("error!");
    }
}
