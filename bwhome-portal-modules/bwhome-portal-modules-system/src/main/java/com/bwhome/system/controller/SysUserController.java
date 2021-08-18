package com.bwhome.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysUserController {

    @GetMapping("/user/info")
    public String userInfo(){
        return "cxm";
    }
}
