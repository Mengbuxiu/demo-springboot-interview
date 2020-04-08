package com.java.book.thinkinjava.basic._10_8;

/**
 * @author Alin
 * @version 1.0
 * @description // 一个class实现两个接口单个类或内部类都可以实现,但是一个class继承两个类,单个类根本做不到.java是出了名的单继承,
 * 所以匿名类很好的解决了多重继承的问题
 * @date 2019/4/28 17:16
 */
class D{}
abstract class E{}
// Z 继承了 D ,且Z的内部还有一个E的匿名类实现
class Z extends D{
    E makeE(){
        return new E() {};
    }
}
public class MultiImplementation {
    static void takeD(D d){}
    static void takeE(E e){}

    public static void main(String[] args) {
        Z z = new Z();
        takeD(z);
        takeE(z.makeE());
    }
}
