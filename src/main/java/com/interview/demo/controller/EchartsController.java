package com.interview.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/echarts")
public class EchartsController {
    @RequestMapping("/double-polyline")
    public String polyline(){
        System.out.println("to_show ======= double-polyline");
        return "/echart/double-polyline";
    }

    @RequestMapping("/meter")
    public String meter(){
        System.out.println("to_show ======= meter");
        return "/echart/meter";
    }

    @RequestMapping("/sankey")
    public String sanki(){
        System.out.println("to_show ======= sankey");
        return "/echart/sankey";
    }
}
