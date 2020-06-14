package com.bee.airsystem.dao;

import com.bee.airsystem.entity.Flight;

import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/7 14:47
 */
public interface FlightDAO extends BaseDAO<Flight> {

    /**
     * 通过ID查找航班
     *
     * @param parseInt 航班id
     * @return 航班对象
     */
    Flight findFlightById(int parseInt);

    List<Flight> search(String departure, String destination);
}
