package com.bee.airsystem.servlet;

import com.bee.airsystem.dao.UserBaseDAOImpl;
import com.bee.airsystem.dao.UserBaseDao;
import com.bee.airsystem.entity.UserBase;
import com.bee.airsystem.utils.TimeUtils;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/5 16:26
 */
public class LoginServletImpl implements LoginServlet {

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
        baseDao.add(new UserBase(userName, nickName, "男", work, id, email, phone, pdw1, null, null));
    }
}
