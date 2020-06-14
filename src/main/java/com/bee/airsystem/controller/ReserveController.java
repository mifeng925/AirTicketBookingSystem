package com.bee.airsystem.controller;

import com.bee.airsystem.config.WebConfig;
import com.bee.airsystem.entity.Flight;
import com.bee.airsystem.service.FlightService;
import com.bee.airsystem.service.FlightServiceImpl;
import com.bee.airsystem.service.ReserveService;
import com.bee.airsystem.service.ReserveServiceImpl;
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
 * @date ：Created in 2020/6/13 10:47
 */
@WebServlet("/reserve")
public class ReserveController extends HttpServlet {

    FlightService flightServlet = new FlightServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String opt = req.getParameter("opt");
        opt = opt == null ? "" : opt;
        switch (opt) {
            case "search":
                String departure = req.getParameter("departure");
                String destination = req.getParameter("destination");
                departure = departure == null ? "" : departure;
                destination = destination == null ? "" : destination;
                List<Flight> flights = flightServlet.searchFlight(departure, destination);
                req.setAttribute("flights", flights);
                RequestUtils.forward(WebConfig.rootPath + "reserve/search.jsp", req, resp);
                break;
            default:
                RequestUtils.forward(WebConfig.rootPath + "reserve.jsp", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flightId = req.getParameter("flightId");
        String userId = req.getParameter("userId");
        ReserveService reserveService = new ReserveServiceImpl();
        reserveService.issueTickets(userId,flightId);
        doGet(req, resp);
    }
}
