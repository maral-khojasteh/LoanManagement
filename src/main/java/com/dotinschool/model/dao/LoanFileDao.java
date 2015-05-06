package com.dotinschool.model.dao;

import com.dotinschool.model.to.LoanFile;
import com.dotinschool.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Maral Khojasteh
 */
public class LoanFileDao {

    public void save(LoanFile loanFile) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(loanFile);
            session.getTransaction().commit();
        }catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
