package com.celivra.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() {
        Connection connection = null;
        String sql = "jdbc:mysql://localhost:3306/cet";
        String user = "root";
        String password = "940727";
        try{
            connection = DriverManager.getConnection(sql, user, password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
