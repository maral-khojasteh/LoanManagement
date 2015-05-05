package com.dotinschool.test;


import com.dotinschool.model.dao.LoanTypeDAO;
import com.dotinschool.model.to.LoanType;

import java.sql.SQLException;

/**
 * Created by Maral ito on 4/23/2015.
 */
public class TestDAO {

    public static void main(String[] args) throws SQLException {


//        LoanTypeDAO loanTypeDAO = new LoanTypeDAO();
//
//        LoanType loanType = new LoanType();
//        loanType.setName("First Loan Type");
//        loanType.setInterestRate(70d);
//        loanTypeDAO.save(loanType);
//
//        GrantConditionDAO grantConditionDAO = new GrantConditionDAO();
//
//        GrantCondition condition1 = new GrantCondition();
//        condition1.setName("Condition 1");
//        condition1.setMinimumAmount(5d);
//        condition1.setMaximumAmount(10d);
//        condition1.setMinimumDays(30);
//        condition1.setMaximumDays(90);
//        condition1.setLoanType(loanType);
//        grantConditionDAO.save(condition1);
//
//        GrantCondition condition2 = new GrantCondition();
//        condition2.setName("Condition 2");
//        condition2.setMinimumAmount(5d);
//        condition2.setMaximumAmount(20d);
//        condition2.setMinimumDays(90);
//        condition2.setMaximumDays(150);
//        condition2.setLoanType(loanType);
//        grantConditionDAO.save(condition2);

        System.out.println("Test");

        LoanTypeDAO loanTypeDAO = new LoanTypeDAO();
        LoanType loanType = loanTypeDAO.findById(1L);
        System.out.println("LoanType (id = 1): " + loanType);


    }

}
