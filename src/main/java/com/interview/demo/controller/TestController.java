package com.interview.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aa")
public class TestController {
    @RequestMapping("/to_index")
    public String test1(){
        System.out.println("to_index ================");
        return "index";
    }
}
