package com.bwhome.common.security.service;

import cn.hutool.core.util.IdUtil;
import com.bwhome.api.system.domain.LoginUser;

public class TokenService {

    public String createToken(LoginUser loginUser){
        String token = IdUtil.simpleUUID();
        // 存数据到redis,token为key
        return token;
    }
}
