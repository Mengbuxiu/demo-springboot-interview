package com.interview.demo.interceptor;

import com._wx_public.yudaoyuanma.entity.User;
import com.google.common.collect.Maps;
import net.sf.ehcache.Element;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class LoginInterCepotr implements HandlerInterceptor {
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
        /**
         * 用户已登陆，在登陆的controller里session.setAttr("userId", User)
         * 然后这里就可以
         * User user = (User)session.getAttr("userId");
         * CURRENT_USER.set(new HashMap<String, User>(){{
         *             put(user.getId(),user);
         *  }});
         */
        return true;
    }

    private static final ThreadLocal<HashMap<String, User>> CURRENT_USER = new ThreadLocal<>();
    private static ThreadLocal<HashMap<String, User>> getCurrentThread() {
        return CURRENT_USER;
    }
    public void setCurrentUser(HashMap<String, User> map) {
        if (map != null) {
            getCurrentThread().set(map);
        }
    }
    /**
     * 暴露给外部调用
     * 获取当前用户
     * @param userId
     * @return
     */
    public User getCurrentUser(String userId) {
        //第一个get是获取当前线程，每一个用户就是一个线程
        return getCurrentThread().get().get(userId);
    }
}
