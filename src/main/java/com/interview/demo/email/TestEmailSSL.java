package com.interview.demo.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;

public class TestEmailSSL {
    public static void main(String[] args) throws UnknownHostException, MessagingException {
        final String host = "smtp.163.com";
        final String userName = "15910344021@163.com";
        final String password = "JTKZCASPIVRTJFQO";
        final String to = "297098453@qq.com";
        final String port = "465";
        final Properties props = new Properties();
        props.setProperty("mail.transport.protocol","SMTP");
        final String hostAddress = InetAddress.getByName(host).getHostAddress();
        props.setProperty("mail.smtp.host", hostAddress);
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.timeout","25000");
//        props.setProperty("mail.smtp.ssl.trust", hostAddress);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port",port);
        final Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        final Session session = Session.getInstance(props, authenticator);
        final MimeMessage message = new MimeMessage(session);
        message.setSentDate(new Date());
        message.setFrom(new InternetAddress(userName));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
        message.setSubject("2222");
        message.setText("hhhhh");
        Transport.send(message);
    }
}
