package com.bee.airsystem.controller;

import com.bee.airsystem.config.WebConfig;
import com.bee.airsystem.entity.UserBase;
import com.bee.airsystem.service.LoginService;
import com.bee.airsystem.service.LoginServiceImpl;
import com.bee.airsystem.utils.RequestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/1 20:02
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestUtils.forward(WebConfig.rootPath + "login.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String psw = req.getParameter("psw");
        String captcha = req.getParameter("captcha");
        String coed = (String) req.getSession().getAttribute("code");

        LoginService servlet = new LoginServiceImpl();
        UserBase u = servlet.login(user, psw);
        String result = "";
        if (Objects.equals(user, "") || Objects.equals(psw, "")) {
            result = "请填写完整信息";
        } else if (!Objects.equals(captcha, coed)) {
            result = "验证码错误";
        } else if (u == null) {
            result = "账号或者密码错误";
        }
        if (Objects.equals(result, "")) {
            req.getSession().setAttribute("user", u);
            resp.sendRedirect("/main");
        } else {
            req.setAttribute("msg", result);
            req.setAttribute("u", user);
            doGet(req, resp);
        }

    }
}
