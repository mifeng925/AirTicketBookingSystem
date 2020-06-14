package com.bee.airsystem.service;

import com.bee.airsystem.entity.UserBase;
import org.junit.Test;

public class LoginServiceImplTest {

    @Test
    public void login() {
        LoginService servlet = new LoginServiceImpl();
        UserBase login = servlet.login("949323", "123");
        System.out.println(login);
    }
}