package com.interview.demo.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author king_zl
 * @version 1.0
 * @description // TODO
 * @date 2019/4/17 15:19
 */
@Service
public class TestCacheService {

    /**
     * 第一次访问时，name还没有缓存，去访问数据库
     * 第二次访问时，本方法不会执行，会直接返回缓存中的结果
     * @return
     */
    @Cacheable("name")
    public String getName(){
        System.out.println("模拟缓存------------------");
        return this.getRealName();
    }

    private String getRealName() {
        System.out.println("模拟真实数据库------------------");
        return "Alin";
    }

}
