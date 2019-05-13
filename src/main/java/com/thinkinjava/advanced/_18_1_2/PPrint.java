package com.thinkinjava.advanced._18_1_2;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Alin
 * @desc //打印机
 * @date 2019/5/13
 */
public class PPrint {
    public static String pformat(Collection<?> c){
        if (0 == c.size()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        for (Object elem : c) {
            if (1 != c.size()) {
                result.append("\n  ");
            }
            result.append(elem);
        }
        if (1 != c.size()) {
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }
    public static void ppint(Collection<?> c){
        System.out.println(pformat(c));
    }
    public static void ppint(Object[] c){
        System.out.println(Arrays.asList(c));
    }
}
