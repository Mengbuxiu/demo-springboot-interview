package com.interview.demo.JsonIsNull;

import com.alibaba.fastjson.JSONArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author king_zl
 * @version 1.0
 * @description // TODO
 * @date 2019/4/23 18:09
 */
public class TestArray {
    public static void main(String[] args) {
        String json = "[{\"book\":[1,2,3]}]";
        JSONArray jsonArray = JSONArray.parseArray(json);
        Object book = jsonArray.getJSONObject(0).get("book");
        List<Object> objects = Collections.singletonList(book);
        System.out.println(objects);
        //objects.forEach(System.out::println);
        //System.out.println(book);
        for (Object o : jsonArray) {
            System.out.println(o);
        }
    }
}
