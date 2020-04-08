package com.java.book.thinkinjava.basic._14_7;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

class Client {
  @Test
  void testCglibProxy() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(Suject.class);
    enhancer.setCallback(new CglibProxy());
    Suject proxy = (Suject) enhancer.create();
    proxy.request();
  }
}