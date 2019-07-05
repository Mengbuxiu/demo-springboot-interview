package com.interest_bug;

import java.util.ArrayList;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/7/4 17:58
 */
public class TestLIst {
    public static void main(String[] args) {
        ArrayList<Integer> v = new ArrayList<Integer>(){{
            add(1);
            add(2);
        }};
        changeVal(v);
        v.forEach(System.out::println);
    }

    private static void changeVal(ArrayList<Integer> v) {
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) == 2){
                //不能修改，也不允许修改
            }
        }
    }
}
