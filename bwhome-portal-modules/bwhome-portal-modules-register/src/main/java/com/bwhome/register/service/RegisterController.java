package com.bwhome.register.service;

import com.bwhome.common.core.web.domain.AjaxResult;
import com.alibaba.fastjson.JSON;
import com.bwhome.register.form.RegisterBody;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 异步发短信
     * @param username
     * @param password
     * @param phoneNum
     * @return
     */
    @GetMapping("/register")
    public AjaxResult register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("phoneNum") String phoneNum){
        if ("cxm".equals(username) && "1998.cxm".equals(password)){
            String messageId = String.valueOf(UUID.randomUUID());
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd :HH:mm:ss"));
            Map<String, String> map = new HashMap<>();
            map.put("messageId", messageId);
            map.put("createTime", createTime);
            map.put("messageData", JSON.toJSONString( new RegisterBody(username, password ,phoneNum)));
            rabbitTemplate.convertAndSend("sendMessageExchange","sendMessageRouting", map);
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd :HH:mm:ss")));
            return AjaxResult.success();
        }
       return AjaxResult.error();
    }
}
