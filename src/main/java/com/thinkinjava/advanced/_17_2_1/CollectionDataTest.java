package com.thinkinjava.advanced._17_2_1;

import com.thinkinjava.basic._15_3.interf.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Alin
 * @version 1.0
 * @description
 * @date 2019/5/9 13:29
 */
class Government implements Generator<String> {
    private String[] foundation = "a b c d e f".split(" ");
    private int index;
    @Override
    public String next() {
        return foundation[index++];
    }
}
public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(
                new CollectionData<>(new Government(),3));
        // 求set和传入set的并集。
        set.addAll(CollectionData.list(new Government(),4));
        System.out.println(set);
    }
}
