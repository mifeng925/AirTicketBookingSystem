package com.bee.airsystem.service;

import com.bee.airsystem.bean.UserTicket;

import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/14 22:07
 */
public interface UserTicketService {

    /**
     * 获取所有订票信息
     *
     * @param userId id
     * @return 所以列表
     */
    List<UserTicket> getAll(String userId);


    /**
     * 轮询查询延误
     *
     * @param userId 用户id
     */
    boolean pollingDelay(String userId);

}
