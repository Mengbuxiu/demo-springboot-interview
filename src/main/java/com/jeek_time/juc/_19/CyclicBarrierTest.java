package com.jeek_time.juc._19;

/**
 * @author Alin
 * @version 1.0
 * @description //
 * @date 2019/7/9 17:47
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        QueneConcurrent qc = new QueneConcurrent();
        boolean b = qc.produceData();
        if (b){
            qc.goods.forEach(System.out::println);
        }
        System.exit(0);
    }
}
