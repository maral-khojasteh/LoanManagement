package com.dotinschool.model.dao;

import com.dotinschool.model.to.GrantCondition;
import com.dotinschool.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Maral ito on 4/30/2015.
 */
public class GrantConditionDAO {

    public void save(GrantCondition grantCondition) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(grantCondition);
            session.getTransaction().commit();
        }catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
    }



}
