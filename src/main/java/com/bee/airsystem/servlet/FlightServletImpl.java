package com.bee.airsystem.servlet;

import com.bee.airsystem.dao.FlightDAO;
import com.bee.airsystem.dao.FlightDAOImpl;
import com.bee.airsystem.dao.PlaneDAO;
import com.bee.airsystem.dao.PlaneDAOBImpl;
import com.bee.airsystem.entity.Flight;
import com.bee.airsystem.entity.Plane;

import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/7 19:23
 */
public class FlightServletImpl implements FlightServlet {

    FlightDAO flightDAO = new FlightDAOImpl();

    @Override
    public List<Flight> getAllFlight() {
        return flightDAO.getAll();
    }

    @Override
    public void del(String id) {
        Flight flight = new Flight(Integer.parseInt(id));
        flightDAO.delete(flight);
    }

    @Override
    public List<Plane> getAllPlane() {
        PlaneDAO planeDAO = new PlaneDAOBImpl();
        return planeDAO.getAll();
    }

    @Override
    public void inset(Flight flight) {
        int id = flight.getId();
        if (id == 0) {
            flightDAO.add(flight);
        } else {
            flightDAO.update(flight);
        }
    }

    @Override
    public Flight findFlightById(int id) {
        return flightDAO.findFlightById(id);
    }

}
