package com.bee.airsystem.servlet;

import com.bee.airsystem.entity.UserBase;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/5 16:26
 */
public interface LoginServlet {

    /**
     * 登录
     *
     * @param user 账号
     * @param pdw  密码
     * @return 登录成功返回用户实例  失败返回null
     */
    UserBase login(String user, String pdw);

    /**
     * 注册用户
     *
     * @param userName 姓名
     * @param nickName 昵称
     * @param id       身份证号
     * @param work     工作单位
     * @param email    邮箱
     * @param phone    电话
     * @param pdw1     密码
     */
    void registeredUser(String userName, String nickName, String id, String work, String email, String phone, String pdw1);
}
