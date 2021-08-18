package com.bwhome.api.system.service;

import com.bwhome.api.system.factory.RemoteUserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="bwhome-system",fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {

    @GetMapping("system/user/info")
    public String getUserInfo();
}
