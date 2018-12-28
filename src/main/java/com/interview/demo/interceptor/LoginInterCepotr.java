package com.interview.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterCepotr implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       HttpSession session = request.getSession();
        if (session.getAttribute("loginStatus") == null ||
                (int)session.getAttribute("loginStatus") == 0){
            response.sendRedirect(request.getContextPath()+"/to_login_page");
            return false;
        }
        return true;
    }
}
