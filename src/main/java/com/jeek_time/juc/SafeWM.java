package com.jeek_time.juc;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Alin
 * @version 1.0
 * @description // 库存静态
 * @date 2019/6/27 11:46
 */
@ToString
@Slf4j
public class SafeWM {
    /**
     * 库存上限
     */
    private final AtomicLong upper = new AtomicLong(10);
    /**
     * 库存下限
     */
    private final AtomicLong lower = new AtomicLong(0);

    void setUpper(long v) {
        // 看见if想竞态条件
        if (v < lower.get()) {
            System.out.println(lower.get() + " : " + upper.get());
            log.error(String.format("库存上限(%d)小于下限(%d)   %d < %d",v,lower.get(),v,lower.get()));
            return;
        }
        upper.set(v);
        System.out.println("------------after update upper------------");
        System.out.println(lower.get() + " : " + upper.get());
    }
    void setLowwer(long v){
        if (v > upper.get()){
            System.out.println(lower.get() + " : " + upper.get());
            log.error(String.format("库存下限(%d)大于上限(%d) %d > %d",v,upper.get(),v,upper.get()));
            return;
        }
        lower.set(v);
        System.out.println("------------after update lower------------");
        System.out.println(lower.get() + " : " + upper.get());
    }
    long getUpper(){
        return this.upper.get();
    }
    long getLower(){
        return this.lower.get();
    }
}
