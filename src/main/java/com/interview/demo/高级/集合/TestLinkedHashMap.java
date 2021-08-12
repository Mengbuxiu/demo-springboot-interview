package com.interview.demo.高级.集合;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhenglin
 *  
 * @desc
 * @date 2021/6/28 10:26 下午
 */
public class TestLinkedHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("以下是accessOrder=true的情况:");

        map = new LinkedHashMap<>(10, 0.75f, true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        System.out.println();
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry);
        }

        map.get("2");//2移动到了内部的链表末尾
//        map.get("4");//4调整至末尾
//        map.put("3", "e");//3调整至末尾
        map.put(null, null);//插入两个新的节点 null
        map.put("5", null);//5
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
