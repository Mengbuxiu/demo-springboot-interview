package com.pattern.策略;

public class StrategyCard implements Strategy{
 
    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
       return charge+charge*0.01;
    }
 }