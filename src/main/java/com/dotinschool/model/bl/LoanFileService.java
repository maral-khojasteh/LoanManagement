package com.dotinschool.model.bl;

import com.dotinschool.model.dao.LoanFileDao;
import com.dotinschool.model.to.LoanFile;

/**
 * @author Maral Khojasteh
 */
public class LoanFileService {

    private LoanFileDao loanFileDao;

    public LoanFileService(){
        loanFileDao = new LoanFileDao();
    }

    public void save(LoanFile loanFile){
        loanFileDao.save(loanFile);
    }
}
