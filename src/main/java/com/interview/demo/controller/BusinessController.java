package com.interview.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/business")
public class BusinessController {
    @RequestMapping("/show")
    public String show(){
        System.out.println("to_show ================");
        return "show";
    }
}
