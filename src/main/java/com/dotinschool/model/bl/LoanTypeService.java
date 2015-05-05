package com.dotinschool.model.bl;

import com.dotinschool.model.dao.LoanTypeDAO;
import com.dotinschool.model.to.LoanType;

import java.util.List;

/**
 * Created by Maral ito on 4/23/2015.
 */
public class LoanTypeService {

    private LoanTypeDAO loanTypeDAO;

    public LoanTypeService() {
        loanTypeDAO = new LoanTypeDAO();
    }

    public void saveLoanType(LoanType loanType) {
        loanTypeDAO.save(loanType);
    }

    public List<LoanType> findAll() {
        return loanTypeDAO.findAll();
    }
}
