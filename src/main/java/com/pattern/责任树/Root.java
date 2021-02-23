package com.pattern.责任树;

import org.springframework.stereotype.Component;
 
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Component
public class Root extends AbstractStrategyRouter<String,Boolean> {
    @Resource
    private Handler_A a;
 
    @Resource
    private Handler_B b;
    /**
     * 定义用来存储执行策略的map集合
     */
    private Map<String,StrategyHandler> strategyMap = new HashMap<>();
 
    /**
     * 创建某个节点下的策略或节点
     * @return
     */
    @Override
    protected StrategyMapper<String,Boolean> registerStrategyMapper() {
        strategyMap.put("A",a);
        strategyMap.put("B",b);
        return new RootStrategyMapperImpl();
    }
 
    /**
     * 实现父类定义的接口，用于实现自己的获取不同的策略
     * 就像文章中所说，可以写if也可以写map，在这我们使用的是map
     */
    class RootStrategyMapperImpl implements StrategyMapper<String,Boolean>{
 
        @Override
        public StrategyHandler<String,Boolean> get(String param) {
            return strategyMap.get(param);
        }
    }
}