package com.pattern.责任树;

/**
 * @author zhenglin
 *  
 * @desc
 * @date 2021/2/22 下午4:12
 */
public class Handler_A implements StrategyHandler {
    @Override
    public Object apply(Object param) {
        System.out.println("这是 <A🍃> 节点 - 可以处理逻辑。");
        return null;
    }
}
