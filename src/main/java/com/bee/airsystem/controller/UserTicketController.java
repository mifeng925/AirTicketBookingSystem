package com.bee.airsystem.controller;

import com.bee.airsystem.bean.UserTicket;
import com.bee.airsystem.config.WebConfig;
import com.bee.airsystem.entity.Flight;
import com.bee.airsystem.entity.UserBase;
import com.bee.airsystem.service.ReserveService;
import com.bee.airsystem.service.ReserveServiceImpl;
import com.bee.airsystem.service.UserTicketService;
import com.bee.airsystem.service.UserTicketServiceImpl;
import com.bee.airsystem.utils.RequestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/14 21:27
 */
@WebServlet("/ticket")
public class UserTicketController extends HttpServlet {
    UserTicketService userTicketService = new UserTicketServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserBase userBase = (UserBase) req.getSession().getAttribute("user");
        List<UserTicket> all = userTicketService.getAll(userBase.getIdentityCard());
        req.setAttribute("ticket", all);
        RequestUtils.forward(WebConfig.rootPath + "ticket.jsp", req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        opt = opt == null ? "" : opt;
        String id = req.getParameter("_id");
        if (id != null) {
            ReserveService reserveService = new ReserveServiceImpl();
            switch (opt) {
                case "del":
                    reserveService.delById(id);
                    break;
                case "boarding":
                    reserveService.boarding(id);
                    break;
                default:
            }
        }
        doGet(req, resp);
    }
}
