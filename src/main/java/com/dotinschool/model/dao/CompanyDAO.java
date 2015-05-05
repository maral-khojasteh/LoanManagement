package com.dotinschool.model.dao;

import com.dotinschool.model.to.Company;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Maral Khojasteh
 */
public class CompanyDAO extends CustomerDAO {

    public void insert(Company company) throws SQLException {
        super.insert(company);
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO company VALUES (?, ?, ?, ?)");
            statement.setLong(1, company.getId());
            statement.setString(2, company.getName());
            statement.setDate(3, new Date(company.getRegistrationDate().getTime()));
            statement.setString(4, company.getEconomicCode());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void update(Company company) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) getConnection().prepareStatement("UPDATE company SET companyName = ?, registrationDate = ?, economicCode = ? WHERE id = ?");
            statement.setString(1, company.getName());
            statement.setDate(2, new Date(company.getRegistrationDate().getTime()));
            statement.setString(3, company.getEconomicCode());
            statement.setLong(4, company.getId());
            statement.executeUpdate();
        }finally {
            if (statement != null){
                statement.close();
            }
        }
    }

    public void delete(long id) throws SQLException {
        PreparedStatement statement = null;
        getConnection().setAutoCommit(false);
        try {
            statement = (PreparedStatement) getConnection().prepareStatement("DELETE FROM company WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        super.delete(id);
        getConnection().commit();
    }

    public boolean doesExistEconomicCode(String economicCode) throws SQLException {

        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) getConnection().prepareStatement("SELECT count(*) from company WHERE economicCode = ?");
            statement.setString(1, economicCode);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }finally {
            if(statement != null){
                statement.close();
            }
        }
    }

    public ArrayList<Company> find(String companyName, String economicCode, String customerNumber) throws SQLException {
        PreparedStatement statement = null;
        String sqlStatement = "SELECT co.*, c.customerNumber from company co INNER JOIN customer c on co.id = c.id WHERE 1 = 1";
        int counter = 0;
        if(!companyName.equals("")){
            sqlStatement = sqlStatement.concat(" AND co.companyName LIKE ?");
        }
        if(!economicCode.equals("")){
            sqlStatement = sqlStatement.concat(" AND co.economicCode LIKE ?");
        }
        if(!customerNumber.equals("")){
            sqlStatement = sqlStatement.concat(" AND c.customerNumber LIKE ?");
        }
        statement = (PreparedStatement) getConnection().prepareStatement(sqlStatement);
        if(!companyName.equals("")){
            counter +=1;
            statement.setString(counter , "%" + companyName + "%");
        }
        if (!economicCode.equals("")){
            counter +=1;
            statement.setString(counter , "%" + economicCode + "%");
        }
        if(!customerNumber.equals("")){
            counter +=1;
            statement.setString(counter , "%" + customerNumber + "%");
        }
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Company> companies = new ArrayList<Company>();
        while (resultSet.next()){
            Company company = new Company();
            company.setId(resultSet.getLong("id"));
            company.setName(resultSet.getString("companyName"));
            company.setEconomicCode(resultSet.getString("economicCode"));
            java.util.Date date = resultSet.getTimestamp("registrationDate");
            company.setRegistrationDate(date);
            company.setCustomerNumber(resultSet.getString("customerNumber"));
            companies.add(company);
        }
        return companies;
    }
}


