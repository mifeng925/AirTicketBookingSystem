package com.bee.airsystem.service;

import com.bee.airsystem.dao.ReserveDAO;
import com.bee.airsystem.dao.ReserveDAOImpl;
import com.bee.airsystem.entity.Reserve;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/14 9:15
 */
public class ReserveServiceImpl implements ReserveService {
    ReserveDAO reserveDAO = new ReserveDAOImpl();
    @Override
    public void issueTickets(String userId, String flightId) {
        Reserve reserve = new Reserve(0, userId, Integer.parseInt(flightId), 0);
        reserveDAO.add(reserve);
    }

    @Override
    public void delById(String id) {
        reserveDAO.deleteById(id);
    }

    @Override
    public void boarding(String id) {
        reserveDAO.boarding(id);
    }
}
