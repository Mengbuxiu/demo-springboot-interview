package com.interview.demo.controller;

import com.interview.demo.interf.StatusSymbol;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @RequestMapping("/to_login_page")
    public String to_login_page(){
        return "login";
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("userPwd") String userPwd,
                        HttpServletRequest request){
        if ("zhenglin".equals(userName) && "123456".equals(userPwd)){
            request.getSession().setAttribute("loginStatus",StatusSymbol.LOGIN_IN);
            return "login_success";
        }
        return "login_fail";
    }
}
