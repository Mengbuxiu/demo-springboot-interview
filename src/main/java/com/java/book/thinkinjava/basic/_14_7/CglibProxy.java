package com.java.book.thinkinjava.basic._14_7;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/7/31 16:35
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before safety check.");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after safety check.");
        return result;
    }
}
