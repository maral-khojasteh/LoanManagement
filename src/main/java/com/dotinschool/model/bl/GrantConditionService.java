package com.dotinschool.model.bl;

import com.dotinschool.model.dao.GrantConditionDAO;
import com.dotinschool.model.to.GrantCondition;

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

}
