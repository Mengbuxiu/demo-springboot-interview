package com.pattern.责任树;

/**
 * @author zhenglin
 *  
 * @desc 中间路由层
 * @date 2021/2/22 下午3:35
 */
public class StrategyRouterB extends AbstractStrategyRouter implements StrategyHandler{
    @Override
    protected StrategyMapper registerStrategyMapper() {
        return null;
    }

    @Override
    public Object apply(Object param) {
        // 参数验证...
        return null;
    }
}
