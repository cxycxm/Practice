package com.bwhome.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BwhomeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BwhomeGatewayApplication.class, args);
        System.out.println("网关启动成功");
    }
}
