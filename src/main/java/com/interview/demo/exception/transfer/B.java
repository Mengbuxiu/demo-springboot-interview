package com.interview.demo.exception.transfer;

/**
 * @author Alin
 * @version 1.0
 * @description // 抛了异常必须处理,
 * 异常不会在方法间传递，【如果你想要程序除了异常还可以继续运行】，则必须层层上抛，最外层处理
 * @date 2019/5/21 19:08
 */
public class B {
    public static void main(String[] args) {
        try {
            A.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("继续执行！");
    }
}
