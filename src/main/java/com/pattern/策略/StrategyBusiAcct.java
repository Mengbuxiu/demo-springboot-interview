package com.pattern.策略;

public class StrategyBusiAcct implements Strategy{

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
       return charge*0.90;
    }
    
} 