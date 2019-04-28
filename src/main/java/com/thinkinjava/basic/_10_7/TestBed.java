package com.thinkinjava.basic._10_7;

/**
 * @author Alin
 * @version 1.0
 * @description // 嵌套类应用实例
 * @date 2019/4/28 11:13
 */
public class TestBed {
//    这是实现的接口
    static void test(){
        System.out.println("This is a static method");
    }
    public void f() {
        System.out.println("f()");
    }
    //这部分就是公共实现
    public static class Tester {
        public static void main(String[] args) {
            TestBed testBed = new TestBed();
            testBed.f();
        }
    }
}
