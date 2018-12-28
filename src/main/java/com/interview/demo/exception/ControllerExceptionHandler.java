package com.interview.demo.exception;

import com.interview.demo.util.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    private static final String ERROR_VIEW = "error";

    //@ExceptionHandler(Exception.class)
//    public Object errorHandler(HttpServletRequest request, Exception e) {
//        e.printStackTrace();
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("Exception", e);
//        mv.addObject("e", "error============");
//        mv.addObject("Exception_Url", request.getRequestURL());
//        mv.setViewName(ERROR_VIEW);
//        return mv;
//    }

    /**
     * 混合异常捕获，controller和ajax
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object errorHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (isAjax(request)){
            return IMoocJSONResult.errorException(e.getMessage());
        } else {
            ModelAndView mv = new ModelAndView();
            mv.addObject("Exception", e);
            mv.addObject("e", "error============");
            mv.addObject("Exception_Url", request.getRequestURL());
            mv.setViewName(ERROR_VIEW);
            return mv;
        }
    }

    /**
     * 判断是否是ajax请求
     * @param request
     * @return
     */
    private boolean isAjax(HttpServletRequest request){
        return request.getHeader("X-Request-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Request-With"));
    }
}
