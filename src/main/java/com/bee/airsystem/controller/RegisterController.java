package com.bee.airsystem.controller;

import com.bee.airsystem.config.WebConfig;
import com.bee.airsystem.servlet.LoginServlet;
import com.bee.airsystem.servlet.LoginServletImpl;
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
 * @date ：Created in 2020/6/1 20:23
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestUtils.forward(WebConfig.rootPath + "register.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String nickName = req.getParameter("nickName");
        String id = req.getParameter("id");
        String work = req.getParameter("work");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String pdw1 = req.getParameter("pdw1");
        String pdw2 = req.getParameter("pdw2");
        String captcha = req.getParameter("captcha");

        String coed = (String) req.getSession().getAttribute("code");

        String result = "";
        if (!Objects.equals(captcha, coed)) {
            result = "验证码不一致";
        } else if (!Objects.equals(pdw1, pdw2)) {
            result = "两次密码不一致";
        }
        if (!Objects.equals(result, "")) {
            req.setAttribute("msg", result);
            doGet(req, resp);
        } else {
            LoginServlet servlet = new LoginServletImpl();
            servlet.registeredUser(userName, nickName, id, work, email, phone, pdw1);
            resp.sendRedirect("/login");
        }

    }
}
