package com.pattern.责任树;

public class Handler_B implements StrategyHandler {
    @Override
    public Object apply(Object param) {
        System.out.println("这是B🍃节点，可以处理逻辑。");
        return null;
    }
}