package com.interview.demo.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/6/21 10:21
 */
@Component
@Slf4j
public class MailServiceImpl{
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendAttachFileMail(String to,
                                   String mailTitle,
                                   String mailContent,
                                   String attachmentFileName,
                                   byte[] attachmentFile) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        if (attachmentFile != null && attachmentFile.length != 0) {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            mimeMessageHelper.addAttachment(
                    MimeUtility.encodeWord(attachmentFileName),
                    new ByteArrayResource(attachmentFile));
        }else {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        }
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setSubject(mailTitle);
        mimeMessageHelper.setText(mailContent);
        mailSender.send(mimeMessage);
    }

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            log.info("简单邮件已经发送。");
        } catch (Exception e) {
            log.error("发送简单邮件时发生异常！", e);
        }
    }
}
