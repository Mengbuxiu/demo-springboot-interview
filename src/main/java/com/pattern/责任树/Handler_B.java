package com.pattern.责任树;

public class Handler_B<T, R> implements StrategyHandler<T, R> {
    @Override
    public R apply(T param) {
        System.out.println("这是 <B🍃> 节点 - 可以处理逻辑。");
        return null;
    }
}