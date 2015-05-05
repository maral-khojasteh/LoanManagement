package com.dotinschool.model.dao;

import com.dotinschool.model.to.Customer;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maral Khojasteh
 */
public class CustomerDAO extends BaseDAO {

    public void insert(Customer customer) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO customer (id, customerNumber) VALUES (NULL, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getCustomerNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = Long.valueOf(resultSet.getInt(1));
            customer.setId(id);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void delete(long id) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) getConnection().prepareStatement("DELETE FROM customer WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public long selectMaxId() throws SQLException {

        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) getConnection().prepareStatement("select max(id) from customer");
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
            return 0;
        }finally {
            if(statement != null){
                statement.close();
            }
        }
    }
}
