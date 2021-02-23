package com.pattern.责任树;

/**
 * @author zhenglin
 *  
 * @desc 中间路由层
 * @date 2021/2/22 下午3:35
 */
public class StrategyRouterB<Object, Boolean> extends AbstractStrategyRouter<Object, Boolean> implements StrategyHandler<Object, Boolean>{

    @Override
    protected StrategyMapper<Object, Boolean> registerStrategyMapper() {
        return null;
    }

    @Override
    public Boolean apply(Object param) {
        return null;
    }
}
