package com.interview.demo.interceptor;

import com._wx_public.yudaoyuanma.entity.User;
import com.google.common.collect.Maps;
import net.sf.ehcache.Element;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoginInterCerpotr implements HandlerInterceptor {
//    static {
//        //初始化
//        CURRENT_USER.set(new HashMap<String, User>() {{
//            put("testUserId", new User().setAge(11).setUserName("Alin"));
//        }});
//    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if (session.getAttribute("loginStatus") == null ||
                (int) session.getAttribute("loginStatus") == 0) {
            response.sendRedirect(request.getContextPath() + "/to_login_page");
            return false;
        }
        /*PrintWriter writer = response.getWriter();
        writer.write(*//*把你要写的文件流转byte*//*Arrays.toString("你好".getBytes(StandardCharsets.UTF_8)));*/
        //response.setContentType("application/xml; charset=utf-8");
        //new File("D:\\work_soft\\idea_wp\\demo-springboot-interview\\src\\main\\resources\\ehcache.xml")
        //ServletOutputStream os = response.getOutputStream();
        //String arr = String.valueOf(new File("D:\\work_soft\\idea_wp\\demo-springboot-interview\\src\\main\\resources\\ehcache.xml"));
        //os.print(arr);
        /**
         * User user = (User) session.getAttribute("user");
         * CURRENT_USER.set(user);
         */
        return false;
    }

    /**
     * 一个意思
     * https://blog.csdn.net/kiloyip/article/details/80171782
     */
    private static final ThreadLocal<User> CURRENT_USER = new ThreadLocal<>();

    private static ThreadLocal<User> getCurrentThread() {
        return CURRENT_USER;
    }

    public void setCurrentUser(User user) {
        if (user != null) {
            getCurrentThread().set(user);
        }
    }

    /**
     * 暴露给外部调用
     * 获取当前用户
     *
     * @return
     */
    public User getCurrentUser() {
        //第一个get是获取当前线程，每一个用户就是一个线程
        return getCurrentThread().get();
    }
}
