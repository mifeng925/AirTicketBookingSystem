package com.bee.airsystem.controller;

import com.bee.airsystem.config.WebConfig;
import com.bee.airsystem.entity.Plane;
import com.bee.airsystem.service.PlaneService;
import com.bee.airsystem.service.PlaneServiceImpl;
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
 * @date ：Created in 2020/6/7 13:28
 */
@WebServlet("/planes")
public class PlansController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlaneService planeServlet = new PlaneServiceImpl();
        List<Plane> all = planeServlet.getAll();
        req.setAttribute("planes", all);
        RequestUtils.forward(WebConfig.rootPath + "planes.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
