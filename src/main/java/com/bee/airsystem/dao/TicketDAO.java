package com.bee.airsystem.dao;

import com.bee.airsystem.bean.UserTicket;

import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/14 21:52
 */
public interface TicketDAO {
    /**
     * 查询当前用户的所以机票
     *
     * @param userId 用户id
     * @return 返回所有订票信息
     */
    List<UserTicket> getAll(String userId);

    /**
     * 轮询查询所以延误航班
     *
     * @param userId id
     * @return 航班
     */
    List<UserTicket> pollingDelay(String userId);

    /**
     * 轮询查询是否停机
     *
     * @param userId id
     * @return 航班
     */
    List<UserTicket> pollingToStop(String userId);


}
