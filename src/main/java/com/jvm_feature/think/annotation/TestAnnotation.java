package com.jvm_feature.think.annotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Alin
 * @version 1.0
 * @description // test
 * @date 2019/8/6 11:35
 */
@Autowired
public @interface TestAnnotation {
    String aaa() default "";
}
