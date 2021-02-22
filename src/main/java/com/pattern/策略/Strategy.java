package com.pattern.策略;

public interface Strategy {
    /**
     * 计算金额
     * @param charge 金额
     * @param type 充值方式
     * @return
     */
    Double calRecharge(Double charge ,RechargeTypeEnum type );
}