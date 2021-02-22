package com.pattern.责任链.拓展;

import javax.servlet.*;
import java.io.IOException;

/**
 * JavaEE的Servlet规范定义的Filter就是一种责任链模式，它不但允许每个Filter都有机会处理请求，还允许每个Filter决定是否将请求“放行”给下一个Filter：
 * 这种模式不但允许一个Filter自行决定处理ServletRequest和ServletResponse，
 * 还可以“伪造”ServletRequest和ServletResponse以便让下一个Filter处理，能实现非常复杂的功能。
 */
public class AuditFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (check(req)) {
            // 放行:
            chain.doFilter(req, resp);
        } else {
            // 拒绝:
            sendError(resp);
        }
    }

    private void sendError(ServletResponse resp) {

    }

    private boolean check(ServletRequest req) {
        return false;
    }

    @Override
    public void destroy() {

    }
}