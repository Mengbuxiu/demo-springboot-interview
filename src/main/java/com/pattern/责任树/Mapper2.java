package com.pattern.责任树;

public class Mapper2 implements AbstractStrategyRouter.StrategyMapper {
    @Override
    public StrategyHandler get(Object param) {
        return new Handler_B();
    }
}