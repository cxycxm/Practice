package com.bwhome.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("472252050@qq.com");
        message.setTo("472252050@qq.com");
        message.setSubject("好好学习");
        message.setText("上号");
        javaMailSender.send(message);
    }

}
