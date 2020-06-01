package com.bee.airsystem.db;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ：Bee
 * @date ：Created in 2020/4/27 14:29
 */
public class MyDbUtils {

    private static DruidDataSource dataSource;

    private static DruidDataSource getInstance() {
        if (dataSource == null) {
            synchronized (MyDbUtils.class) {
                if (dataSource == null) {
                    dataSource = new DruidDataSource();
                    dataSource.setUrl("jdbc:mysql://localhost:3306/aviation_system");

                    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

                    dataSource.setUsername("root");
                    dataSource.setPassword("root");

                    dataSource.setInitialSize(1);
                    dataSource.setMinIdle(1);
                    dataSource.setMaxActive(10);

                    dataSource.setMaxWait(20 * 1000);
                    dataSource.setTimeBetweenEvictionRunsMillis(20 * 1000);

                    dataSource.setValidationQuery("SELECT 'x'");
                    dataSource.setTestWhileIdle(true);
                    dataSource.setTestOnBorrow(true);
                }
            }
        }
        return dataSource;
    }

    public static Connection connection() throws SQLException {
        return getInstance().getConnection();
    }

}
