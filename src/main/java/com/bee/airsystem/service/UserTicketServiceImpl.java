package com.bee.airsystem.service;

import com.bee.airsystem.bean.UserTicket;
import com.bee.airsystem.dao.ReserveDAO;
import com.bee.airsystem.dao.ReserveDAOImpl;
import com.bee.airsystem.dao.TicketDAO;
import com.bee.airsystem.dao.TicketDAOImpl;

import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/14 22:07
 */
public class UserTicketServiceImpl implements UserTicketService {

    TicketDAO ticketDAO = new TicketDAOImpl();

    @Override
    public List<UserTicket> getAll(String userId) {
        return ticketDAO.getAll(userId);
    }

    @Override
    public boolean pollingDelay(String userId) {
        List<UserTicket> userTickets = ticketDAO.pollingDelay(userId);
        ReserveDAO reserveDAO = new ReserveDAOImpl();
        for (UserTicket ticket :
                userTickets) {
            reserveDAO.delayed(ticket.getReserveId());
        }
        return userTickets.size() > 0;
    }
}
