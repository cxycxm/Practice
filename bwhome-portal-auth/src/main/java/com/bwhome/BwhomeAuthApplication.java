package com.bwhome;

import com.bwhome.common.core.interceptor.RepeatSubmitInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients(basePackages = "com.bwhome.api.system.service")
@SpringBootApplication
public class BwhomeAuthApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BwhomeAuthApplication.class, args);
        System.out.println(((ConfigurableApplicationContext) applicationContext).getBean(RepeatSubmitInterceptor.class));
        System.out.println("认证中心启动成功");
    }
}
