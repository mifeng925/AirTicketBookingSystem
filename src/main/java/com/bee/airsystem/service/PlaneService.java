package com.bee.airsystem.service;

import com.bee.airsystem.entity.Plane;

import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/7 13:49
 */
public interface PlaneService {

    /**
     * 获取所有飞机
     *
     * @return 所有飞机
     */
    List<Plane> getAll();
}
