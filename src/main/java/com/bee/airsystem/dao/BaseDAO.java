package com.bee.airsystem.dao;

import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/5/17 22:53
 */
interface BaseDAO<T> {

    /**
     * 获取所有数据
     *
     * @return 放回所有实体集合
     */
    List<T> getAll();

    /**
     * 删除实体
     *
     * @param t 实体
     * @return Success return true else false
     */
    boolean delete(T t);

    /**
     * 更新实体
     *
     * @param t 实体参数
     * @return Success return true else false
     */
    boolean update(T t);

    /**
     * 增加实体
     *
     * @param ts 实体
     */

    @SuppressWarnings("varargs")
    void add(final T... ts);

}
