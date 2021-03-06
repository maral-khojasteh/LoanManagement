package com.dotinschool.model.bl;

import com.dotinschool.model.dao.CompanyDAO;
import com.dotinschool.model.to.Company;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Maral Khojasteh
 */
public class CompanyService extends CustomerService{

    private CompanyDAO companyDAO;

    public CompanyService(){
        companyDAO = new CompanyDAO();
    }

    public void insertCompany(Company company) throws SQLException {
        companyDAO.save(company);
    }

    public void editCompany(Company company) throws SQLException {companyDAO.save(company);}

    public void deleteCompany(long companyId) throws SQLException {
        companyDAO.delete(companyId);
    }

//    public void closeConnection() throws Exception {
//        companyDAO.close();
//    }

    public boolean doesExistEconomicCode(String economicCode) throws SQLException {
        return companyDAO.doesExistEconomicCode(economicCode);
    }

    public List<Company> findCompany(String companyName, String economicCode, String customerNumber) throws SQLException {
        return companyDAO.find(companyName, economicCode, customerNumber);
    }
}
