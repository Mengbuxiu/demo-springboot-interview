package com.interview.demo.JsonIsNull;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author king_zl
 * @version 1.0
 * @description // json递归判空
 * @date 2019/4/23 10:25
 */
public class TestJSON {
    public static void main(String[] args) {
        //String json1 = "{\"name\":\"Alin\",\"age\":18,\"readBook\":[\"java1\",\"java2\",\"java3\",\"java4\"]}";
//        String json3 = "{" +
//                            "\"name\":\"Alin\"," +
//                            "\"age\":18," +
//                            "\"readBook\":" +
//                                "[" +
//                                  "{\"java\":[\"java编程思想\",\"代码大全\"]}" +
//                                  "{\"web\":[\"typescript入门\",\"锋利的jQuery\"]}" +
//                                  "{\"linux\":null}" +
//                                "]" +
//                        "}";

//        String json2 = "{" +
//                        "\"name\":\"Alin\"," +
//                        "\"age\":18," +
//                        "\"readBook\":" +
//                            "{\"java\":\"java编程思想\"}" +
//                      "}";
        String json4 = "[" +
                            "{" +
                                "\"name\":\"Alin\"," +
                                "\"age\":18," +
                                "\"readBook\":" +
                                    "[" +
                                        "{\"java\":[\"java编程思想\",\"代码大全\"]}" +
                                        "{\"web\":[]}" +
                                        "{\"linux\":null}" +
                                    "]" +
                            "}" +
                        "]";
        //System.out.println(json3.startsWith("{"));
        JSONArray jsonArray = JSONArray.parseArray(json4);
        System.out.println(recursiveCheckArgsIsNullByArray(jsonArray));
    }

    /**
     * json4 最终版，对于最外层是对象即[]的有效
     * 多层递归查询value是否为null
     * @param jsonArray
     * @return
     */
    private static boolean recursiveCheckArgsIsNullByArray(JSONArray jsonArray){
        if (jsonArray.size() == 0) {
            return true;
        }
        for (Object o : jsonArray) {
            if (o instanceof JSONObject)
                recursiveCheckArgsIsNullByObject((JSONObject) o);
            if (o instanceof JSONArray){
                boolean flag = recursiveCheckArgsIsNullByArray((JSONArray) o);
                if (flag){
                    System.out.println("JSONArray: " + o);
                }
            }
        }
        return false;
    }
    /**
     * json3 最终版，对于最外层是对象即{}的有效
     * 多层递归查询value是否为null
     * @param jsonObject
     * @return
     */
    private static boolean recursiveCheckArgsIsNullByObject(JSONObject jsonObject){
        if (jsonObject == null) {
            return false;
        }
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object val = jsonObject.get(key);
            System.out.println("key = " + key + "  val = " + val);
            if (val == null || "".equals(val)) {
                System.out.println(key + ".value is null,please check your args!");
                return true;
            }
            if (val instanceof JSONObject) {
                recursiveCheckArgsIsNullByObject((JSONObject) val);
            }
            if (val instanceof JSONArray) {
                for (Object v : (JSONArray) val) {
                    if (v instanceof String)
                        continue;
                    recursiveCheckArgsIsNullByObject((JSONObject) v);
                }
            }
        }
        return false;
    }
//    /**
//     * json2
//     * 多层递归查询value是否为null
//     * @param jsonObject
//     * @return
//     */
//    private static boolean recursiveCheckArgsIsNull(JSONObject jsonObject){
//
//        if (jsonObject == null) {
//            return false;
//        }
//
//        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
//        for (Map.Entry<String, Object> entry : entries) {
//            String key = entry.getKey();
//            Object val = jsonObject.get(key);
//            System.out.println("key = " + key + "  val = " + val);
//            if (val == null || "".equals(val)) {
//                System.out.println(key + ".value is null,please check your args!");
//                return true;
//            }
//            if (val instanceof JSONObject) {
//                recursiveCheckArgsIsNull((JSONObject) val);
//            }
////            if (val instanceof Array) {
////                recursiveCheckArgsIsNull((JSONObject) val);
////            }
//        }
//        return false;
//    }
    /**
     * json1
     * 仅仅只是一层的情况，如果是多层的话得写递归
     * @param jsonObject
     * @return
     */
//    private static boolean checkArgsIsNull(JSONObject jsonObject) {
//        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
//        for (Map.Entry<String, Object> entry : entries) {
//            String key = entry.getKey();
//            Object val = jsonObject.get(key);
//            System.out.println("key = " + key + "  val = " + val);
//            if (val == null || "".equals(val)) {
//                System.out.println(key + ".value is null,please check your args!");
//                return true;
//            }
//        }
//        return false;
//    }
}
