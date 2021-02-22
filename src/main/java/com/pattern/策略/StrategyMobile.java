package com.pattern.策略;

public class StrategyMobile implements Strategy {

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
       return charge;
    }
    
}