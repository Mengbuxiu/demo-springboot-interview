package com.java_feature;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author king_zl
 * @version 1.0
 * @description // 移除JSONObject中JSONArray的某个值，JSONObject中的数组长度也缩小
 * @date 2019/4/9 15:31
 */
public class TestJson {
    public static void main(String[] args) {
        String json = "{\"A\":\"a\",\"B\":[\"b\",\"bb\",\"bbb\",\"bbbb\"]}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray b = jsonObject.getJSONArray("B");
        b.remove(0);
        System.out.println(jsonObject.toJSONString());
        //{"A":"a","B":["bb","bbb","bbbb"]}
    }
}
