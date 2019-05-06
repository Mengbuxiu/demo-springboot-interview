package com.thinkinjava.basic._14_7;

import static java.lang.System.*;
/**
 * @author Alin
 * @version 1.0
 * @description // 代理模式
 * @date 2019/4/30 15:37
 *
 * interface A { void a(); }
 *
 * class B impl A {
 *      @override
 *      void a(){
 *          sout("I'm b...");
 *      }
 * }
 *
 * class ProxyC impl A {
 *      private A a;//代理接口
 *      ProxyC(A a){
 *          this.a = a;
 *      }
 *      @override
 *      void a(){
 *          sout("I'm proxyC...");
 *          a.a();//I'm b...
 *      }
 * }
 *
 * 所谓的代理模式，就是不直接去调用某个方法，而是去调用代理的方法，让代理去调用你需要调用的方法
 * 代理类和被代理类应该共同实现一个接口，或者是共同继承某个类。
 *
 * 注释中代理类ProxyC和被代理类B都实现了接口A，ProxyC调用接口A的方法实现时会调用自身的接口A实现，然后再去调B的A方法实现
 */
interface Interface {
    void doSomething();
    void somethingElse(String args);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        out.println("RealObject doSomething()");
    }

    @Override
    public void somethingElse(String args) {
        out.println(String.format("RealObject somethingElse(%s) " ,args));
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    SimpleProxy(Interface anInterface){
        this.proxied = anInterface;
    }

    @Override
    public void doSomething() {
        out.println("SimpleProxy proxied.doSomething() -> 我将代理外部对RealObject doSomething()的调用");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String args) {
        out.println(String.format("SimpleProxy proxied.somethingElse(%s) -> 我将代理外部对RealObject somethingElse(%s)的调用" ,args,args));
        proxied.somethingElse(args);
    }
}

class SimpleProxyDemo{
    public static void main(String[] args) {
        consumer(new RealObject());
        out.println();
        consumer(new SimpleProxy(new RealObject()));
        out.println();
    }

    private static void consumer(Interface proxied) {
        proxied.doSomething();
        proxied.somethingElse(" fuck world ");
    }
}
