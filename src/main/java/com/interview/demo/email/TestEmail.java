package com.interview.demo.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alin
 * @version 1.0
 * @description // 邮件发送
 * @date 2019/6/21 10:16
 */
@ExtendWith(SpringExtension.class) //导入spring测试框架
@SpringBootTest  //提供spring依赖注入
class TestEmail {
    @Autowired
    private MailServiceImpl service;
    @Value("${mail.to.addr}")
    private String to;

    @Test
    void testSend(){
       service.sendSimpleMail(to,"test","this is for test");
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());

        exec.shutdown();
    }
}
