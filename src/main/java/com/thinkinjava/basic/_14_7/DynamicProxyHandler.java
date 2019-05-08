package com.thinkinjava.basic._14_7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Alin
 * @version 1.0
 * @description // 代理类
 * @date 2019/4/30 16:28
 */
class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(String.format("*** proxy: %s , method: %s , args: %s",
                proxy.getClass().getSimpleName(), method, Arrays.toString(args)));

        if (args != null) {
            for (Object arg : args) {
                System.out.println(String.format(" args'value is %s", arg));
            }
        }
        return null;
    }
}

/**
 * 测试demo
 * Q:为什么称为动态代理？
 * A:实现InvocationHandler的代理类是每个需要被代理的接口所共用的，内部不会写死某个接口，
 *  而是在外部以数组的方式传递进去
 */
class SimpleDynamicProxy{
    public static void main(String[] args) {
        /**
         *  需要被代理的接口 real = new 被代理类
         */
        Subject real = new RealObject();
        consumer(real);
        /**
         *  Proxy.newProxyInstance(定义代理类的类加载器[事实上系统的类加载器也是可以的], Clazz[能够被代理的接口], 代理类[被代理接口])
         */
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(
                /**
                 * 以下三种都可以
                 * 原因是 他们都是使用的AppClassLoader
                 * */
                ClassLoader.getSystemClassLoader()
                /*DynamicProxyHandler.class.getClassLoader()*/
                /*InvocationHandler.class.getClassLoader()*/,
                new Class[]{Subject.class},
                /** 代理类 (被代理类), 注入需要被代理的接口 */
                new DynamicProxyHandler(real));
        consumer(proxyInstance);
    }

    private static void consumer(Subject anSubject) {
        anSubject.doSomething();
        anSubject.somethingElse(" fuck world ");
    }
}