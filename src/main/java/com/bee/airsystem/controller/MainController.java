package com.bee.airsystem.controller;

import com.bee.airsystem.config.WebConfig;
import com.bee.airsystem.entity.UserBase;
import com.bee.airsystem.service.UserTicketService;
import com.bee.airsystem.service.UserTicketServiceImpl;
import com.bee.airsystem.utils.RequestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/5 20:19
 */
@WebServlet("/main")
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserTicketService userTicketService = new UserTicketServiceImpl();
        UserBase user = (UserBase) req.getSession().getAttribute("user");
        boolean delayed = userTicketService.pollingDelay(user.getIdentityCard());
        boolean stop = userTicketService.pollingToStop(user.getIdentityCard());
        req.setAttribute("delayed", delayed);
        req.setAttribute("stop", stop);
        RequestUtils.forward(WebConfig.rootPath + "main.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
