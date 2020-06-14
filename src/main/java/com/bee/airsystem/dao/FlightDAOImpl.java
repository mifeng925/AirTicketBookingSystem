package com.bee.airsystem.dao;

import com.bee.airsystem.db.MyDbUtils;
import com.bee.airsystem.entity.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/7 14:48
 */
public class FlightDAOImpl implements FlightDAO {

    @Override
    public List<Flight> getAll() {
        List<Flight> flights = new ArrayList<>();
        try {
            Connection connection = MyDbUtils.connection();
            String sql = "SELECT * From flight f1,(SELECT name,plane_id FROM plane) f2 WHERE f1.plane_id=f2.plane_id order by _id desc";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Flight flight = getFlights(resultSet, true);
                flights.add(flight);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    @Override
    public boolean delete(Flight flight) {
        boolean result = false;
        try {
            Connection cnn = MyDbUtils.connection();
            String sql = "DELETE FROM flight WHERE _id=?";
            PreparedStatement statement = cnn.prepareStatement(sql);
            statement.setInt(1, flight.getId());
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
    public boolean update(Flight flight) {
        boolean result = false;
        try {
            Connection cnn = MyDbUtils.connection();

            String sql = "UPDATE flight SET " +
                    "plane_id=?,departure=?,destination=?,price=?," +
                    "flag=?,start_time=?,arrival_time=? WHERE _id=?";

            PreparedStatement statement = setFlight(flight, cnn, sql);
            statement.setInt(8, flight.getId());
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
    public void add(Flight... flights) {
        for (Flight flight : flights) {
            try {
                Connection connection = MyDbUtils.connection();
                String sql = "INSERT INTO flight(plane_id,departure,destination,price,flag,start_time,arrival_time) VALUES(?,?,?,?,?,?,?) ";
                PreparedStatement statement = setFlight(flight, connection, sql);
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 设置参数
     *
     * @param flight     flight对象
     * @param connection 链接对象
     * @param sql        sql语句
     * @return 返回SQL准备执行对象
     * @throws SQLException 异常抛出
     */
    private PreparedStatement setFlight(Flight flight, Connection connection, String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, flight.getPlaneId());
        statement.setString(2, flight.getDeparture());
        statement.setString(3, flight.getDestination());
        statement.setDouble(4, flight.getPrice());
        statement.setInt(5, flight.getFlag());
        statement.setString(6, flight.getStartTime());
        statement.setString(7, flight.getArrivalTime());
        return statement;
    }

    @Override
    public Flight findFlightById(int id) {
        try {
            Connection connection = MyDbUtils.connection();
            String sql = "SELECT * From flight WHERE _id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Flight flight = getFlights(resultSet, false);
            preparedStatement.close();
            resultSet.close();
            connection.close();
            return flight;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Flight> search(String departure, String destination) {
        List<Flight> flights = new ArrayList<>();
        try {
            Connection connection = MyDbUtils.connection();
            String sql = "SELECT * From flight WHERE departure LIKE ? AND destination LIKE ? AND start_time>sysdate()";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + departure + "%");
            preparedStatement.setString(2, "%" + destination + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Flight flight = getFlights(resultSet, false);
                flights.add(flight);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    private Flight getFlights(ResultSet resultSet, boolean havaName) throws SQLException {
        int id = resultSet.getInt("_id");
        String planeId = resultSet.getString("plane_id");
        String departure = resultSet.getString("departure");
        String destination = resultSet.getString("destination");
        double price = resultSet.getDouble("price");
        int flag = resultSet.getInt("flag");
        String startTime = resultSet.getString("start_time");
        String arrivalTime = resultSet.getString("arrival_time");

        if (havaName) {
            String name = resultSet.getString("name");
            return new Flight(id, planeId, name, departure, destination, price, flag, startTime, arrivalTime);
        } else {
            return new Flight(id, planeId, departure, destination, price, flag, startTime, arrivalTime);
        }

    }
}
