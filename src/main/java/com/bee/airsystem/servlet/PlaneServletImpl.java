package com.bee.airsystem.servlet;

import com.bee.airsystem.dao.PlaneDAO;
import com.bee.airsystem.dao.PlaneDAOBImpl;
import com.bee.airsystem.entity.Plane;

import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/7 13:49
 */
public class PlaneServletImpl implements PlaneServlet {

    PlaneDAO planeDAO = new PlaneDAOBImpl();

    @Override
    public List<Plane> getAll() {
        List<Plane> all = planeDAO.getAll();
        return all;
    }
}
