package com.bee.airsystem.dao;

import com.bee.airsystem.db.MyDbUtils;
import com.bee.airsystem.entity.Plane;
import com.bee.airsystem.entity.UserBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/7 13:43
 */
public class PlaneDAOBImpl implements PlaneDAO {


    @Override
    public List<Plane> getAll() {
        List<Plane> planes = new ArrayList<>();
        try {
            Connection connection = MyDbUtils.connection();
            String sql = "SELECT * From plane";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Plane plane = getPlanes(resultSet);
                planes.add(plane);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }

    private Plane getPlanes(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("_id");
        String planeId = resultSet.getString("plane_id");
        String name = resultSet.getString("name");
        int seats = resultSet.getInt("seats");
        String image = resultSet.getString("image");
        return new Plane(id,planeId,name,seats,image);
    }

    @Override
    public boolean delete(Plane plane) {
        return false;
    }

    @Override
    public boolean update(Plane plane) {
        return false;
    }

    @Override
    public void add(Plane... planes) {

    }
}
