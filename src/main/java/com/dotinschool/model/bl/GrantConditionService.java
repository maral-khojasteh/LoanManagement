package com.dotinschool.model.bl;

import com.dotinschool.model.dao.GrantConditionDAO;
import com.dotinschool.model.to.GrantCondition;
import com.dotinschool.model.to.LoanType;
import org.hibernate.Hibernate;

import java.util.Set;

/**
 * Created by Maral ito on 4/23/2015.
 */
public class GrantConditionService {

    private GrantConditionDAO grantConditionDAO;

    public GrantConditionService() {
        grantConditionDAO = new GrantConditionDAO();
    }

    public void saveGrantCondition(GrantCondition grantCondition) {
        grantConditionDAO.save(grantCondition);
    }

    public boolean find(LoanType loanType, Double amount, Integer duration){
        Set<GrantCondition> conditions = loanType.getConditions();
        for(GrantCondition condition: conditions){
            if(amount >= condition.getMinimumAmount() && amount<= condition.getMaximumAmount() && duration>= condition.getMinimumDays() && duration<= condition.getMaximumDays()){
                return true;
            }
        }
        return false;
    }

}
