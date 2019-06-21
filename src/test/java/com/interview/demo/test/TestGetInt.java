package com.interview.demo.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles
public class TestGetInt {
    public static void main(String[] args) {
        String ips = "{\"ip\":null}";
        JSONObject parse = JSONObject.parseObject(ips);
        Integer ip = parse.getInteger("ip");
        System.out.println("ip = " + ip);
    }
}