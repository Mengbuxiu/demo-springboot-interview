package com.interview.demo.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author king_zl
 * @version 1.0
 * @description // TODO
 * @date 2019/4/17 15:18
 */
public class TestSpringCache {

    public static String name(){
        TestCacheService service = new TestCacheService();
        return service.getName();
    }

    public static void main(String[] args) {

    }
}
