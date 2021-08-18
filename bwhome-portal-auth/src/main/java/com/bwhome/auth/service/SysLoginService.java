package com.bwhome.auth.service;

import com.bwhome.api.system.domain.LoginUser;
import com.bwhome.auth.form.LoginBody;

public class SysLoginService {

    public LoginUser login(LoginBody loginBody){
        return new LoginUser();
    }

    public void logout(String username){

    }
}
