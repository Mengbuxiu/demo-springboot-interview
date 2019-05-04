package com.thinkinjava.basic._14_7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Alin
 * @version 1.0
 * @description // java代理模式
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
                proxy.getClass(), method, Arrays.toString(args)));

        if (args != null) {
            for (Object arg : args) {
                System.out.println(String.format(" args'value is %s", arg));
            }
        }
        return null;
    }
}

class SimpleDynamicProxy{
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        Interface proxyInstance = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxyInstance);
    }

    private static void consumer(Interface anInterface) {
        anInterface.doSomething();
        anInterface.somethingElse(" fuck world ");
    }
}