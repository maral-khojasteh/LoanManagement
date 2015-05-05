package com.dotinschool.model.dao;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Maral ito on 4/23/2015.
 */
public class BaseDAO {

    private Connection connection;

    public BaseDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/customermanagement?user=root&password=root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() {
        return connection;
    }

//    public void close() throws Exception {
//        connection.close();
//    }

}
