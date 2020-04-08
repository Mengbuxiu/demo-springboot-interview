package com.java.book.thinkinjava.basic._10_7.interf;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/4/28 11:17
 * 搜来的资料
 * https://blog.csdn.net/SnailMann/article/details/80231593
 */
public interface Bed {
    void material();

    /**
     * 床的公共动作
     * 10.7.1 中的实现思想似乎已经可以用default来替代了
     */
    // class BedCommon {
    default void sleep() {
        System.out.println("sleep()");
    }
    //     }

    static void tear(){
        System.out.println("一言不合就拆床");
    }
}
