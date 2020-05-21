package com.interview.demo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alin
 * @desc //TODO
 * @date 2019/5/19
 */
@RestController
@RequestMapping("/stream")
public class StreamController {
    @RequestMapping("/in")
    public String error(HttpServletResponse response) throws IOException {
        String name = "D:\\work_soft\\idea_wp\\demo-springboot-interview\\src\\main\\resources\\ehcache.xml";
        FileOutputStream outputStream = new FileOutputStream(name);
        response.getWriter().write(String.valueOf(outputStream));
        /*BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        response.getWriter().write(String.valueOf(bufferedOutputStream));*/
        return "error";
    }
}
