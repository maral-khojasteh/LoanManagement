package com.dotinschool.model.dao;

import com.dotinschool.model.to.Company;
import com.dotinschool.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;

/**
 * @author Maral Khojasteh
 */
public class CompanyDAO extends CustomerDAO {

    public void save(Company company){

        super.save(company);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(company);
            session.getTransaction().commit();
        }catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public void delete(long id){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Company company = (Company) session.load(Company.class, id);
        session.delete(company);
        session.getTransaction().commit();
    }

    public boolean doesExistEconomicCode(String economicCode){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Company where economicCode = :economicCode");
        query.setString("economicCode", economicCode);
        Iterator iterator = query.iterate();
        boolean result = iterator.hasNext();
        session.getTransaction().commit();
        return result;
    }

    public List<Company> find(String companyName, String economicCode, String customerNumber){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Company.class);
        if(!companyName.equals("")){
            criteria.add(Restrictions.like("companyName", companyName));
        }
        if (!economicCode.equals("")){
            criteria.add(Restrictions.like("economicCode", economicCode));

        }
        if(!customerNumber.equals("")){
            criteria.add(Restrictions.like("customerNumber", customerNumber));
        }
        List companies = criteria.list();
        session.getTransaction().commit();
        return companies;
    }
}


