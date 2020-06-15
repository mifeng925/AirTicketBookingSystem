package com.bee.airsystem.dao;

import com.bee.airsystem.entity.Reserve;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/14 9:11
 */
public interface ReserveDAO extends BaseDAO<Reserve> {

    /**
     * 通过id删除
     *
     * @param id id
     * @return 成功返回true
     */
    boolean deleteById(String id);

    /**
     * 登机
     *
     * @param id id
     */
    void boarding(String id);

    /**
     * 延误
     *
     * @param id id
     */
    void delayed(int id);
}
