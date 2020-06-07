package com.bee.airsystem.servlet;

import com.bee.airsystem.entity.UserBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServletImplTest {

    @Test
    public void login() {
        LoginServlet servlet = new LoginServletImpl();
        UserBase login = servlet.login("949323", "123");
        System.out.println(login);
    }
}