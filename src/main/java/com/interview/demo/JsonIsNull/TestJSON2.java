package com.interview.demo.JsonIsNull;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.Set;

import static java.lang.System.*;

/**
 * @author king_zl
 * @version 1.0
 * @description // json递归判空
 * @date 2019/4/23 10:25
 */
public class TestJSON2 {
    public static void main(String[] args) {

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
        Object object = JSONArray.parse(json4);
        out.println(recursiveCheckArgsIsNull(object));
    }

    /**
     * json3 最终版，对于最外层是对象即{}的有效
     * 多层递归查询value是否为null
     * @return
     */
    private static boolean recursiveCheckArgsIsNull(Object object){

        if (object == null) {
            return false;
        }
        if (object instanceof JSONObject) {
            Set<Map.Entry<String, Object>> entries = ((JSONObject)object).entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String key = entry.getKey();
                Object val = ((JSONObject)object).get(key);
                out.println("key = " + key + "  val = " + val);
                if (val == null) {
                    out.println(key + ".value is null,please check your args!");
                    return true;
                }
                if (val instanceof JSONObject) {
                    recursiveCheckArgsIsNull(val);
                }
            }
        }
        if (object instanceof JSONArray) {
            for (Object o : ((JSONArray) object)) {
                recursiveCheckArgsIsNull(o);
            }
//            if (((JSONArray)object).size() == 0) {
//                return false;
//            }
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
