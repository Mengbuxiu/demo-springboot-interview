package com.pattern.责任树;

/**
 * @author zhenglin
 *  
 * @desc
 * @date 2021/2/22 下午4:43
 */
public class Mapper1 implements AbstractStrategyRouter.StrategyMapper {
    @Override
    public StrategyHandler get(Object param) {
        return new Handler_A();
    }
}
