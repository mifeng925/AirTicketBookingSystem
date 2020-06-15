package com.bee.airsystem.dao;

import com.bee.airsystem.bean.UserTicket;
import com.bee.airsystem.db.MyDbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/14 21:52
 */
public class TicketDAOImpl implements TicketDAO {

    @Override
    public List<UserTicket> getAll(String userId) {
        List<UserTicket> userTickets = new ArrayList<>();
        try {
            Connection connection = MyDbUtils.connection();
            String sql = "SELECT * FROM user_base,user_reserve,flight,plane WHERE " +
                    "user_base.identity_card=? AND " +
                    "user_base.identity_card=user_reserve.identity_card AND " +
                    "user_reserve.flight_id=flight._id AND " +
                    "flight.plane_id=plane.plane_id ORDER BY user_reserve._id DESC";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                String nickName = resultSet.getString("nick_name");
                String sex = resultSet.getString("sex");
                String wordUnit = resultSet.getString("work_unit");
                String identityCard = resultSet.getString("identity_card");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                int status = resultSet.getInt("status");
                String departure = resultSet.getString("departure");
                String destination = resultSet.getString("destination");
                double price = resultSet.getDouble("price");
                String startTime = resultSet.getString("start_time");
                String arrivalTime = resultSet.getString("arrival_time");
                int flag = resultSet.getInt("flag");
                String planeName = resultSet.getString("name");
                int reserveId = resultSet.getInt("_id");
                UserTicket ticket = new UserTicket(userName, nickName, sex, wordUnit, identityCard, email, phone, status, departure, destination, price, startTime, arrivalTime, flag, planeName, reserveId);
                userTickets.add(ticket);
            }
            statement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userTickets;
    }

    @Override
    public List<UserTicket> pollingDelay(String userId) {
        List<UserTicket> userTickets = new ArrayList<>();
        try {
            Connection connection = MyDbUtils.connection();
            String sql = "SELECT * FROM user_reserve ,flight WHERE " +
                    "identity_card=? AND " +
                    "user_reserve.flight_id=flight._id AND " +
                    "`status`=0 AND start_time <SYSDATE()";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int reserveId = resultSet.getInt("_id");
                UserTicket ticket = new UserTicket(reserveId);
                userTickets.add(ticket);
            }
            statement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userTickets;
    }
}
