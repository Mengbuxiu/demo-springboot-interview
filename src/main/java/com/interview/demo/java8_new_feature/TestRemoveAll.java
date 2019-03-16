package com.interview.demo.java8_new_feature;

import java.util.*;

public class TestRemoveAll {
    public static void main(String[] args) {
        //removeAll 交集可以用于map 对比 k v 值
        List<HashMap<String,Object>> list1 = new ArrayList<>();
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("name","z");
        list1.add(map1);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("age","1");
        list1.add(map2);

        List<HashMap<String,Object>> list2 = new ArrayList<>();
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("name","z");
        list2.add(map3);
        list1.removeAll(list2);
        for (Map map: list1) {
            Collection values = map.values();
            for (Object value : values) {
                System.out.println(value);
            }

        }
    }
}
