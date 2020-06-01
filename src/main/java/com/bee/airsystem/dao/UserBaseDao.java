package com.bee.airsystem.dao;

import com.bee.airsystem.entity.UserBase;

/**
 * @author ：Bee
 * @date ：Created in 2020/5/29 19:33
 */
public interface UserBaseDao extends BaseDAO<UserBase> {

    /**
     * 通过身份证查找用户
     *
     * @param identityCard 身份证号
     * @return user
     */
    UserBase findByIdentityCard(String identityCard);
}
