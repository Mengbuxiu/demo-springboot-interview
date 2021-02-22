package com.pattern.责任树;

/**
 * @author zhenglin
 *  
 * @desc 中间路由层
 * @date 2021/2/22 下午3:34
 */
public class StrategyRouterA extends AbstractStrategyRouter implements StrategyHandler{
    @Override
    protected StrategyMapper registerStrategyMapper() {
        // 决定走向
        return null;
    }

    @Override
    public Object apply(Object param) {
        // 参数验证...
        return null;
    }
}
