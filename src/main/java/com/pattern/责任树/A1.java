package com.pattern.责任树;

import org.springframework.stereotype.Component;
 
@Component
public class A1 implements StrategyHandler<String,Boolean> {
    @Override
    public Boolean apply(String param) {
        System.out.println("A1开始执行");
        System.out.println("A1开始完毕");
        return true;
    }
}
