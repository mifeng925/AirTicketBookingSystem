package com.bee.airsystem.service;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/14 9:14
 */
public interface ReserveService {
    /**
     * 订票
     *
     * @param userId   用户id
     * @param flightId 航班id
     */
    void issueTickets(String userId, String flightId);

    /**
     * 通过id删除预定航班
     *
     * @param id id信息
     */
    void delById(String id);

    /**
     * 登机
     *
     * @param id 预定id
     */
    void boarding(String id);
}
