package com.jeek_time.小马哥spring.一;

import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhenglin
 *  
 * @desc
 * @date 2021/3/2 上午10:31
 */
public class ResolvableTypeDemo2 {
    private HashMap<Integer, List<String>> myMap;

    public static void main(String[] args) throws NoSuchFieldException {

        ResolvableType t = ResolvableType.forField(ResolvableTypeDemo2.class.getDeclaredField("myMap"));
        System.out.println(t.getSuperType());
        System.out.println(t.asMap());
        System.out.println(t.getGeneric(0).resolve());
        System.out.println(t.getGeneric(1).resolve());
        System.out.println(t.getGeneric(1));
        System.out.println(t.resolveGeneric(1, 0));
    }
}
