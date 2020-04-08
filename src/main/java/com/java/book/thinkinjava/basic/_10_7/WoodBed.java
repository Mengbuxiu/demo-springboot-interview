package com.java.book.thinkinjava.basic._10_7;

import com.java.book.thinkinjava.basic._10_7.interf.Bed;

/**
 * @author Alin
 * @version 1.0
 * @description // 接口中定义default方法实现
 * @date 2019/4/28 11:21
 */
public class WoodBed implements Bed {
    @Override
    public void material() {
        System.out.println("This is wood bed.");
    }

    public static void main(String[] args) {
        Bed b = new WoodBed();
        b.material();
        b.sleep();
        //调用接口中的静态方法和调用类中的静态方法是一样的
        /**
         * 好奇怪啊,为什么很多工具类中的static方法的访问修饰符都是
         * public static Type methodName呢?直接
         * static Type methodName不就好了?
         * 反正调用时都是
         * Clazz.methodName
         * 有毒的吧...
         * 很奇怪吗?
         * public 的意思是在整个项目中都可以调用 Clazz.methodName
         * 不写public你调个试试!
         */
        Bed.tear();
        TestBed.test();
    }
}
