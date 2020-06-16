package com.bee.airsystem.service;

import com.bee.airsystem.dao.UserBaseDAOImpl;
import com.bee.airsystem.dao.UserBaseDao;
import com.bee.airsystem.entity.UserBase;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/5 16:26
 */
public class LoginServiceImpl implements LoginService {

    UserBaseDao baseDao = new UserBaseDAOImpl();

    @Override
    public UserBase login(String user, String pdw) {
        UserBase u;
        u = baseDao.findByIdentityCard(user);
        if (u != null) {
            u = u.getPassWord().equals(pdw) ? u : null;
        }
        return u;
    }

    @Override
    public void registeredUser(String userName, String nickName, String id, String work, String email, String phone, String pdw1) {
        baseDao.add(new UserBase(userName, nickName, "男", work, id, email, 0, phone, pdw1, null, null));
    }
}
