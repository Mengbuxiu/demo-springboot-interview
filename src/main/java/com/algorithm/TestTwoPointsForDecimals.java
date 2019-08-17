package com.algorithm;

import org.junit.jupiter.api.Test;

/**
 * @author Alin
 * @version 1.0
 * @description // 不用数学库对开根2小数点后10位[二分求]
 * @date 2019/8/17 10:37
 */
class TestTwoPointsForDecimals {
    private static final double diff = 0.0000000001;
    @Test
    void test() {
        double low = 1.4;
        double high = 1.5;
        double mid = (low + high)/2;
        while (high - low> diff) {
            if (mid * mid > 2) {
                high = mid;
            }else {
                low = mid;
            }
            mid = (low + high)/2;
        }
        System.out.println(mid);
    }
    @Test
    void sqrt2(){
        System.out.println(Math.sqrt(2));
    }
}
