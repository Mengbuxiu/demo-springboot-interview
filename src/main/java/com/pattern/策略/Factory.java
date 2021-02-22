package com.pattern.策略;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private static Factory factory = new Factory();

    private Factory() {
    }

    private static Map<Integer, Strategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(RechargeTypeEnum.E_BANK.value(), new StrategyEBank());
        strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), new StrategyBusiAcct());
        strategyMap.put(RechargeTypeEnum.MOBILE.value(), new StrategyMobile());
        strategyMap.put(RechargeTypeEnum.CARD_RECHARGE.value(), new StrategyCard());
    }

    public Strategy creator(Integer type) {
        return strategyMap.get(type);
    }

    public static Factory getInstance() {
        return factory;
    }
} 