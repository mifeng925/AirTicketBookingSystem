package com.bee.airsystem.controller;

import com.bee.airsystem.config.WebConfig;
import com.bee.airsystem.entity.Flight;
import com.bee.airsystem.entity.Plane;
import com.bee.airsystem.servlet.FlightServlet;
import com.bee.airsystem.servlet.FlightServletImpl;
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
 * @date ：Created in 2020/6/7 18:20
 */
@WebServlet("/flight")
public class FlightManagerController extends HttpServlet {

    FlightServlet flightServlet = new FlightServletImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Plane> planes = flightServlet.getAllPlane();
        String opt = req.getParameter("opt");
        //解决空指针异常
        opt = opt == null ? "" : opt;
        switch (opt) {
            case "add":
                req.setAttribute("planes", planes);
                RequestUtils.forward(WebConfig.rootPath + "/flight/add.jsp", req, resp);
                break;
            case "update":
                req.setAttribute("planes", planes);
                String id1 = req.getParameter("id");
                Flight flight = flightServlet.findFlightById(Integer.parseInt(id1));
                req.setAttribute("id", flight.getId());
                req.setAttribute("plane", flight.getPlaneId());
                req.setAttribute("departure", flight.getDeparture());
                req.setAttribute("destination", flight.getDestination());
                req.setAttribute("price", flight.getPrice());
                req.setAttribute("flag", flight.getFlag());
                req.setAttribute("startTime", flight.getStartTime());
                req.setAttribute("endTime", flight.getArrivalTime());
                RequestUtils.forward(WebConfig.rootPath + "/flight/add.jsp", req, resp);
                break;
            case "del":
                String id = req.getParameter("_id");
                flightServlet.del(id);
                break;
            default:
                List<Flight> all = flightServlet.getAllFlight();
                req.setAttribute("flights", all);
                RequestUtils.forward(WebConfig.rootPath + "flight.jsp", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        id = id == "" ? "0" : id;
        String plane = req.getParameter("plane");
        String departure = req.getParameter("departure");
        String destination = req.getParameter("destination");
        String price = req.getParameter("price");
        String flag = req.getParameter("flag");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        Flight flight = new Flight(Integer.parseInt(id), plane, departure, destination, Double.parseDouble(price), Integer.parseInt(flag), startTime, endTime);
        flightServlet.inset(flight);
        doGet(req, resp);
    }
}
