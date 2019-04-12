package com.interview.demo.parse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author king_zl
 * @version 1.0
 * @description // TODO
 * @date 2019/4/12 15:45
 */
public class StringToInteger {
    public static void main(String[] args) {
        String json = "[{\"a\":1，\"aa\":11},{\"b\":2,\"bb\":22}]";
        JSONArray parse = (JSONArray) JSONArray.parse(json);
        System.out.println(parse.getJSONObject(0).get("a"));
    }
}
