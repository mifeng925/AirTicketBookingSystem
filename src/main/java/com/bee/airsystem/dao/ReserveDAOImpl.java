package com.bee.airsystem.dao;

import com.bee.airsystem.db.MyDbUtils;
import com.bee.airsystem.entity.Reserve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/14 9:12
 */
public class ReserveDAOImpl implements ReserveDAO {

    @Override
    public List<Reserve> getAll() {
        return null;
    }

    @Override
    public boolean delete(Reserve reserve) {
        return false;
    }

    @Override
    public boolean update(Reserve reserve) {
        return false;
    }

    @Override
    public void add(Reserve... reserves) {
        for (Reserve reserve : reserves) {
            try {
                Connection connection = MyDbUtils.connection();
                String sql = "INSERT INTO user_reserve(identity_card, flight_id, status) VALUES(?,?,?) ";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, reserve.getIdentityCard());
                statement.setInt(2, reserve.getFlightId());
                statement.setInt(3, 0);
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean deleteById(String id) {
        boolean result = false;
        try {
            Connection cnn = MyDbUtils.connection();
            String sql = "DELETE FROM user_reserve WHERE _id=?";
            PreparedStatement statement = cnn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
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
    public void boarding(String id) {
        try {
            Connection cnn = MyDbUtils.connection();
            String sql = "UPDATE user_reserve SET status=1 WHERE _id=?";
            PreparedStatement statement = cnn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
            statement.execute();
            statement.close();
            cnn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delayed(int id) {
        try {
            Connection cnn = MyDbUtils.connection();
            String sql = "UPDATE user_reserve SET status=2 WHERE _id=?";
            PreparedStatement statement = cnn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            cnn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
