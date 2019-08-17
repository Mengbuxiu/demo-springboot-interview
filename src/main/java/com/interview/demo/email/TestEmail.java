package com.interview.demo.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Alin
 * @version 1.0
 * @description // 邮件发送
 * @date 2019/6/21 10:16
 */
@ExtendWith(SpringExtension.class) //导入spring测试框架
@SpringBootTest  //提供spring依赖注入
public class TestEmail {
    @Autowired
    private MailServiceImpl service;
    @Value("${mail.from.addr}")
    private String to;

    @Test
    void testSend(){
       service.sendSimpleMail(to,"test","warning!!!has from");
    }
}
