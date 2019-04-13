package com.java_feature.tenum.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 性别赋值
 * @author zl
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface InitSex {
    /**
     * sex enum
     * @author zzs
     */
    enum SEX_TYPE {MAN, WOMAN}
    SEX_TYPE sex() default SEX_TYPE.MAN;
}