package com.java.book.thinkinjava.basic._10_8;

/**
 * @author Alin
 * @version 1.0
 * @description // 在一个类中使用某种方式实现两个接口
 * @date 2019/4/28 15:13
 */

interface A{void a();}
interface B{void b();}

/**
 * low 实现
 */
class X implements A,B{
    @Override
    public void a() {
        System.out.println("method a ----------");
    }

    @Override
    public void b() {
        System.out.println("method b ----------");
    }
}

/**
 * 666的实现
 * 用上了匿名内部类,世界都变美好了...简洁美观又易懂
 *
 * 总的来说,两种方式都是可以的,但这是接口,如果是抽象类呢?
 */
class Y {
    B makeB(){
        // anonymous inner class for lambda
        return () -> System.out.println("method b -----  lambda ----");
    }

    A makeA(){
        // anonymous inner class
        return () -> System.out.println("method a -----  lambda ----");
    }
}
public class MultiInterfaces {
//    static void takeA(A a){
//        System.out.println(a.getClass() + " : " + a.getClass().getSimpleName());
//    }
//    static void takeB(B b){
//        System.out.println(b.getClass() + " : " + b.getClass().getSimpleName());
//    }
    public static void main(String[] args) {
        X x = new X();
        x.a();
        /*takeA(x);
        takeB(x);
        Y y = new Y();
        takeA(y.makeA());
        takeB(y.makeB());*/
        Y y = new Y();
        y.makeA().a();
        y.makeB().b();
    }
}
