package com.interest_bug;

/**
 * @author Alin
 * @version 1.0
 * @description // 死循环bug
 * @date 2019/6/25 10:55
 */
public class IntLongFor {
    public static void main(String[] args) {
        long totalPage = Long.MAX_VALUE;
        for(int i = 0 ;i<totalPage;i++){
                System.out.println(i+"  >>>>>>>>");
            if(i<0){
                System.out.println(i+"  <<<<<<<<");
            }
        }
    }
}
