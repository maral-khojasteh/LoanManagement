package com.dotinschool.model.dao;

import com.dotinschool.model.to.Customer;
import com.dotinschool.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Maral Khojasteh
 */
public class CustomerDAO{

    public void save(Customer customer){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
        }catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public long selectMaxId(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("select max(id) from Customer");
        Long maxId = (Long) query.list().get(0);
        session.getTransaction().commit();
        return maxId;
    }
}
