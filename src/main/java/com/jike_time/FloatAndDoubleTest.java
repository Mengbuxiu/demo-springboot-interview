package com.jike_time;

import java.math.BigDecimal;

/**
 * @author Alin
 * @version 1.0
 * @description // FloatAndDoubleTest
 * @date 2019/6/4 9:30
 */
public class FloatAndDoubleTest {
    public static void main(String[] args) {
        /*float a = 0.3f;
        float b = 0.6f;
        0.90000004*/
        double a = 0.3;
        double b = 0.6;
        //0.8999999999999999
        //System.out.println(a + b);
        //BigDecimal val = new BigDecimal(a).add(new BigDecimal(b));
        //0.899999999999999966693309261245303787291049957275390625
        //why?因为 传入构造函数的a不是刚好等于 0.3 0.6

        //正确姿势 因为String的值是确定的
        BigDecimal val1 = new BigDecimal(Double.toString(a)).add(new BigDecimal(Double.toString(b)));
        System.out.println(val1);
    }
}
