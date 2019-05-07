package com.thinkinjava.basic._14_7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

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
                proxy.getClass().getSimpleName(), method, Arrays.toString(args)));

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
        Subject real = new RealObject();
        consumer(real);
        System.out.println("" + Subject.class.getSimpleName());
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                new DynamicProxyHandler(real));
        consumer(proxyInstance);
    }

    private static void consumer(Subject anSubject) {
        anSubject.doSomething();
        anSubject.somethingElse(" fuck world ");
    }
}