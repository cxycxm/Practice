package com.bwhome.email.service;

import com.alibaba.fastjson.JSON;
import com.bwhome.email.form.RegisterBody;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
@RabbitListener(queues = "sendMessageQueue")
public class  SendMessageService {
    @Autowired
    private EmailService emailService;

    @RabbitHandler
    public void process(Map<String, String> message) throws InterruptedException {
        String messageData = message.get("messageData");
        RegisterBody registerBody = JSON.parseObject( messageData , RegisterBody.class);
        System.out.println(registerBody.getPhoneNum());
        Thread.sleep(2000);
        System.out.println(registerBody);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd :HH:mm:ss")));
        emailService.sendEmail();
    }
}
