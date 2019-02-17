package com.interview.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class DataController {

    @RequestMapping("/testSanki")
    public String testSanki() {
        return "";
    }

    @RequestMapping("/testPolyline")
    public String testPolyline() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 1; i <= 60; i++) {
            strings.add(i + "");
        }

        ArrayList<Integer> nums1 = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            nums1.add((int) (Math.random() * 1000));
        }

        ArrayList<Integer> nums2 = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            nums2.add((int) (Math.random() * 1000));
        }

        Map map1 = new HashMap();
        map1.put("time", strings);
        map1.put("line1", nums1);
        map1.put("line2", nums2);

        return JSONObject.toJSONString(map1);
    }
}
