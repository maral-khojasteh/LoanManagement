package com.dotinschool.model.dao;

import com.dotinschool.model.to.Person;
import com.dotinschool.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @author Maral Khojasteh
 */
public class PersonDAO extends CustomerDAO {

    public void save(Person person){
        super.save(person);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(person);
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
        Person person = (Person) session.load(Person.class, id);
        session.delete(person);
        session.getTransaction().commit();
    }

    public boolean doesExistNationalCode(String nationalCode){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Person where nationalCode = :nationalCode");
        query.setString("nationalCode", nationalCode);
        Iterator iterator = query.iterate();
        boolean result = iterator.hasNext();
        session.getTransaction().commit();
        return result;
    }

    public List<Person> find(String firstName, String lastName, String nationalCode, String customerNumber) throws SQLException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Person.class);
        if(!firstName.equals("")){
            criteria.add(Restrictions.like("firstName", firstName));
        }
        if(!lastName.equals("")){
            criteria.add(Restrictions.like("lastName", lastName));
        }
        if(!nationalCode.equals("")){
            criteria.add(Restrictions.like("nationalCode", nationalCode));
        }
        if(!customerNumber.equals("")){
            criteria.add(Restrictions.like("customerNumber", customerNumber));
        }
        List persons = criteria.list();
        session.getTransaction().commit();
        return persons;
    }

    public List<Person> findByCustomerNumber(String customerNumber){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Person.class);
        criteria.add(Restrictions.eq("customerNumber", customerNumber));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }

    public Person findById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Person person = (Person) session.load(Person.class, id);
        Hibernate.initialize(person.getCustomerNumber());
        session.getTransaction().commit();
        return person;
    }
}
