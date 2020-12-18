package com.didi.日记总结;

/**
 * @author zhenglin
 *  
 * @desc
 * @date 2020/12/18 上午10:53
 */
public class IntegerAndint {
    public static void main(String[] args) {
        int a = 1;
        Integer b = null;
        int c = b;//npe,解决：对b进行null判断
        System.out.println(a == b);
    }
}
