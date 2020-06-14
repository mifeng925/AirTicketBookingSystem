package com.bee.airsystem.service;

import com.bee.airsystem.entity.Flight;
import com.bee.airsystem.entity.Plane;

import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/7 19:23
 */
public interface FlightService {

    /**
     * 获取所有flight数据
     *
     * @return flights
     */
    List<Flight> getAllFlight();

    void del(String id);

    List<Plane> getAllPlane();

    void inset(Flight flight);

    Flight findFlightById(int parseInt);

    List<Flight> searchFlight(String departure, String destination);
}
