package com.interview.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/aa")
public class TestController {
    @RequestMapping("/to_index")
    public String test1(){
        System.out.println("to_index ================");
        return "index";
    }
    @RequestMapping("/boot")
    public String boot(){
        System.out.println("to_testBootStrap ================");
        return "testBootStrap";
    }
    @PostMapping(value = "/params", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, String> params(){
        Map<String, String> map = new HashMap<>();
        map.put("data", "success");
        return map;
    }
}
