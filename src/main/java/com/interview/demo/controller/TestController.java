package com.interview.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/type")
public class TestController {
    @PostMapping(value = "/body/none")
    @ResponseBody
    public Map<String, String> none(@RequestBody JSONObject object){
        final String name = object.getString("name");
        Map<String, String> map = new HashMap<>();
        map.put("data", name);
        return map;
    }

    @PostMapping(value = "/body/form-data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, String> form_data(@RequestParam("name") String name){
        Map<String, String> map = new HashMap<>();
        map.put("data", name);
        return map;
    }

    @PostMapping(value = "/body/x-www-form-urlencoded", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, String> urlencoded(@RequestParam("name") String name){
        Map<String, String> map = new HashMap<>();
        map.put("data", name);
        return map;
    }

    @PostMapping(value = "/body/raw", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, String> raw(@RequestBody JSONObject object){
        final String name = object.getString("name");
        Map<String, String> map = new HashMap<>();
        map.put("data", name);
        return map;
    }

    @PostMapping(value = "/body/binary", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public Map<String, String> binary(@RequestBody JSONObject object){
        final String name = object.getString("name");
        Map<String, String> map = new HashMap<>();
        map.put("data", name);
        return map;
    }


    /*@PostMapping(value = "/params", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, String> params(@RequestBody JSONObject object){
        final String name = object.getString("name");
        Map<String, String> map = new HashMap<>();
        map.put("data", name);
        return map;
    }*/
}
