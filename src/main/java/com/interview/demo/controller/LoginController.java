package com.interview.demo.controller;

import com.alibaba.fastjson.JSON;
import com.interview.demo.cache.TestCacheService;
import com.interview.demo.interf.StatusSymbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private TestCacheService service;

    @RequestMapping("/to_login_page")
    public String to_login_page(){
        return "login";
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("userPwd") String userPwd,
                        HttpServletRequest request){
        Map<String, String> map = new HashMap<>();
        if ("zhenglin".equals(userName) && "123456".equals(userPwd)){
            request.getSession().setAttribute("loginStatus",StatusSymbol.LOGIN_IN);
            map.put("status", "1");
            map.put("msg", "success");
            System.out.println(service.getName());
            return JSON.toJSONString(map);
        }
        map.put("status", "0");
        map.put("msg", "fail");
        return JSON.toJSONString(map);
    }
}
