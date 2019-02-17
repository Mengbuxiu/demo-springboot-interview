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
    @RequestMapping("/testPolyline")
    public String testPolyline(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");

        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(10);
        nums1.add(20);
        nums1.add(40);
        nums1.add(110);
        nums1.add(70);

        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(4);
        nums2.add(21);
        nums2.add(34);
        nums2.add(223);
        nums2.add(124);

        Map map1 = new HashMap();
        map1.put("time",strings);
        map1.put("line1",nums1);
        map1.put("line2",nums2);

        return JSONObject.toJSONString(map1);
    }
}
