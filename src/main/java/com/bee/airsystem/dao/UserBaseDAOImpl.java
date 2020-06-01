package com.bee.airsystem.dao;

import com.bee.airsystem.db.MyDbUtils;
import com.bee.airsystem.entity.UserBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/5/29 19:34
 */
public class UserBaseDAOImpl implements UserBaseDao {

    @Override
    public List<UserBase> getAll() {
        List<UserBase> users = new ArrayList<>();
        try {
            Connection connection = MyDbUtils.connection();
            String sql = "SELECT * From user_base";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                String nickName = resultSet.getString("nick_name");
                String sex = resultSet.getString("sex");
                String workUnit = resultSet.getString("work_unit");
                String identityCard = resultSet.getString("identity_card");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String createTime = resultSet.getString("create_time");
                String updateTime = resultSet.getString("update_time");
                UserBase userBase = new UserBase(userName, nickName, sex, workUnit, identityCard, email, phone, createTime, updateTime);
                users.add(userBase);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean delete(UserBase userBase) {
        boolean result = false;
        try {
            Connection cnn = MyDbUtils.connection();
            String sql = "DELETE FROM user_base WHERE identity_card=?";
            PreparedStatement statement = cnn.prepareStatement(sql);
            statement.setString(1, userBase.getIdentityCard());
            int code = statement.executeUpdate();
            if (code >= 1) {
                result = true;
            }
            statement.close();
            cnn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(UserBase userBase) {
        boolean result = false;
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        try {
            Connection cnn = MyDbUtils.connection();

            String sql = "UPDATE user_base SET " +
                    "user_name=?,nick_name=?,sex=?,work_unit=?," +
                    "email=?,phone=?,update_time=? WHERE identity_card=?";

            PreparedStatement statement = cnn.prepareStatement(sql);
            statement.setString(1, userBase.getUserName());
            statement.setString(2, userBase.getNickName());
            statement.setString(3, userBase.getSex());
            statement.setString(4, userBase.getWorkUnit());
            statement.setString(5, userBase.getEmail());
            statement.setString(6, userBase.getPhone());
            statement.setString(7, now);
            statement.setString(8, userBase.getIdentityCard());
            statement.setString(1, userBase.getIdentityCard());
            int code = statement.executeUpdate();
            statement.close();
            cnn.close();
            if (code >= 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void add(UserBase... userBases) {
        for (UserBase user : userBases) {
            String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            try {
                Connection connection = MyDbUtils.connection();
                String sql = "INSERT INTO user_base VALUES(?,?,?,?,?,?,?,?,?) ";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getNickName());
                statement.setString(3, user.getSex());
                statement.setString(4, user.getWorkUnit());
                statement.setString(5, user.getIdentityCard());
                statement.setString(6, user.getEmail());
                statement.setString(7, user.getPhone());
                statement.setString(8, now);
                statement.setString(9, now);
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public UserBase findByIdentityCard(String identityCard) {
        UserBase user = null;
        try {
            Connection connection = MyDbUtils.connection();
            String sql = "SELECT * From user_base WHERE identity_card=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, identityCard);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                String nickName = resultSet.getString("nick_name");
                String sex = resultSet.getString("sex");
                String workUnit = resultSet.getString("work_unit");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String createTime = resultSet.getString("create_time");
                String updateTime = resultSet.getString("update_time");
                user = new UserBase(userName, nickName, sex, workUnit, identityCard, email, phone, createTime, updateTime);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
