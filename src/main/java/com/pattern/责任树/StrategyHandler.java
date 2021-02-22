package com.pattern.责任树;

/**
 * 除了根节点外，都要实现 StrategyHandler<T, R> 接口。如果是叶子节点，由于不需要再向下委托，
 * 因此不再需要同时继承 AbstractStrategyRouter<T, R> 抽象类，只需要在 R apply(T param);
 * 中实现业务逻辑即可。对于其他责任树中的中间层节点，都需要同时继承 Router 抽象类和实现 Handler 接口，
 * 在 R apply(T param); 方法中首先进行一定异常入参拦截，遵循 fail-fast 原则，避免将这一层可以拦截的错误传递到下一层，
 * 同时也要避免“越权”做非本层职责的拦截校验，避免产生耦合，为后面业务拓展挖坑。
 * 在拦截逻辑后直接调用本身 {@link AbstractStrategyRouter} 的 public R applyStrategy(T param) 方法路由给下游节点即可。
 */
public interface StrategyHandler<T, R> {
    @SuppressWarnings("rawtypes")
    StrategyHandler DEFAULT = t -> null;

    /**
     * apply strategy
     * @param param
     * @return
     */
    R apply(T param);
}
