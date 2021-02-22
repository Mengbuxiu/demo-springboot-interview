package com.pattern.策略;

public class MobileStrategy implements Strategy {

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
       return charge;
    }
    
}