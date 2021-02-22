package com.pattern.策略;

/**
 * 接口 {@code Strategy} 和 {@code Context} 是重要组成。
 * 上下文中的 {@method calRecharge} 负责即时转换策略
 */
public class Context {
 
    private Strategy strategy;
   
    public Double calRecharge(Double charge, Integer type) {
       strategy = Factory.getInstance().creator(type);
       return strategy.calRecharge(charge, RechargeTypeEnum.valueOf(type));
    }
 
    public Strategy getStrategy() {
       return strategy;
    }
 
    public void setStrategy(Strategy strategy) {
       this.strategy = strategy;
    }
   
}