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
 *
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
        out.println("SimpleProxy doSomething()");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String args) {
        out.println(String.format("SimpleProxy somethingElse(%s) " ,args));
        proxied.somethingElse(args);
    }
}

class SimpleProxyDemo{
    public static void main(String[] args) {
        cosumer(new RealObject());
        out.println();
        cosumer(new SimpleProxy(new RealObject()));
        out.println();
    }

    private static void cosumer(Interface proxied) {
        proxied.doSomething();
        proxied.somethingElse(" fuck world ");
    }
}
