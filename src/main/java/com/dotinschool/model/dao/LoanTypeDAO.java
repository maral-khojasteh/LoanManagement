package com.dotinschool.model.dao;

import com.dotinschool.model.to.GrantCondition;
import com.dotinschool.model.to.LoanType;
import com.dotinschool.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Maral ito on 4/30/2015.
 */
public class LoanTypeDAO {

    public void save(LoanType loanType, List<GrantCondition> grantConditionsList) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            for(GrantCondition grantCondition: grantConditionsList){
                session.saveOrUpdate(grantCondition);
            }
            session.saveOrUpdate(loanType);
            session.getTransaction().commit();
        }catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public void delete(LoanType loanType) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(loanType);
        session.getTransaction().commit();
    }

    public LoanType findById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        LoanType loanType = (LoanType) session.load(LoanType.class, id);
        Hibernate.initialize(loanType.getConditions());
        session.getTransaction().commit();
        return loanType;
    }

    public List<LoanType> findByName1(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from LoanType where name like :name");
        query.setString("name", name);
        return query.list();
    }

    public List<LoanType> findByName2(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LoanType.class);
        criteria.add(Restrictions.like("name", name));
        return criteria.list();
    }

    public List<LoanType> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from LoanType");
        List result = query.list();
        session.getTransaction().commit();
        return result;
    }
}
