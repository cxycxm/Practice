package com.bwhome.api.system.factory;

import com.bwhome.api.system.service.RemoteUserService;
import org.springframework.stereotype.Component;

@Component
public class RemoteUserFallbackFactory {

    public RemoteUserService create(Throwable throwable){
        System.out.println(throwable.getMessage());
        System.out.println("服务调用失败");
        return new RemoteUserService(){
            @Override
            public String getUserInfo() {
                return "调用失败" + throwable.getMessage();
            }
        };
    }
}
