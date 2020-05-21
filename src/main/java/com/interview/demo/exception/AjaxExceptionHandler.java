package com.interview.demo.exception;

import com.interview.demo.util.IMoocJSONResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AjaxExceptionHandler {
    @ExceptionHandler(Exception.class)
    public IMoocJSONResult defaultErrorHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        return IMoocJSONResult.errorException(e.getMessage());
    }

    
}
