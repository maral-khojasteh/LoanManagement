package com.dotinschool.model.bl;

import com.dotinschool.model.dao.CustomerDAO;

import java.sql.SQLException;

/**
 * @author Maral Khojasteh
 */
public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService(){
        customerDAO = new CustomerDAO();
    }

    public String generateCustomerNumber() throws SQLException {
        if (customerDAO.selectMaxId() == 0){
            return String.valueOf(1);
        }
        return String.valueOf(customerDAO.selectMaxId()+1);
    }
}
