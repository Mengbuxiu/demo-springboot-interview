package com.interview.demo.controller;

import com.interview.demo.util.IMoocJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/error")
    public String error(){
        int index = 1/0;
        return "error";
    }

    @RequestMapping("/getAjaxError")
    @ResponseBody
    public IMoocJSONResult getAjaxerror() {

        int a = 1 / 0;

        return IMoocJSONResult.ok();
    }
}
