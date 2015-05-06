package com.dotinschool.model.dao;

import com.dotinschool.model.to.Person;
import com.dotinschool.util.HibernateUtil;
import com.mysql.jdbc.PreparedStatement;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maral Khojasteh
 */
public class PersonDAO extends CustomerDAO {

    public void insert(Person person) throws SQLException {
        super.insert(person);
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

    public void update(Person person) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) getConnection().prepareStatement("UPDATE person SET firstName = ?, lastName = ?, fatherName = ?, birthDate = ?, nationalCode = ? WHERE id = ?");
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getFatherName());
            statement.setDate(4, new Date(person.getBirthDate().getTime()));
            statement.setString(5, person.getNationalCode());
            statement.setLong(6, person.getId());
            statement.executeUpdate();
        }finally {
            if (statement != null){
                statement.close();
            }
        }
    }

    public void delete(long id) throws SQLException {
        PreparedStatement statement = null;
        getConnection().setAutoCommit(false);
        try {
            statement = (PreparedStatement) getConnection().prepareStatement("DELETE FROM person WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        super.delete(id);
        getConnection().commit();
    }

    public boolean doesExistNationalCode(String nationalCode) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) getConnection().prepareStatement("SELECT COUNT(*) FROM person WHERE nationalCode = ?");
            statement.setString(1, nationalCode);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public ArrayList<Person> find(String firstName, String lastName, String nationalCode, String customerNumber) throws SQLException {
        PreparedStatement statement = null;
        String sqlStatement = "SELECT p.*, c.customerNumber FROM person p INNER JOIN customer c ON p.id = c.id WHERE 1 = 1";
        int counter = 0;
        if(!firstName.equals("")){
            sqlStatement = sqlStatement.concat(" AND p.firstName LIKE ?");
        }
        if(!lastName.equals("")){
            sqlStatement = sqlStatement.concat(" AND p.lastName LIKE ?");
        }
        if(!nationalCode.equals("")){
            sqlStatement = sqlStatement.concat(" AND p.nationalCode LIKE ?");
        }
        if(!customerNumber.equals("")){
            sqlStatement = sqlStatement.concat(" AND c.customerNumber LIKE ?");
        }
        statement = (PreparedStatement) getConnection().prepareStatement(sqlStatement);
        if(!firstName.equals("")){
            counter += 1;
            statement.setString(counter, "%" + firstName + "%");
        }
        if(!lastName.equals("")){
            counter += 1;
            statement.setString(counter, "%" + lastName + "%");
        }
        if(!nationalCode.equals("")){
            counter += 1;
            statement.setString(counter, "%" + nationalCode + "%");
        }
        if(!customerNumber.equals("")){
            counter += 1;
            statement.setString(counter, "%" + customerNumber + "%");
        }
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Person> persons = new ArrayList<Person>();
        while (resultSet.next()){
            Person person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setFirstName(resultSet.getString("firstName"));
            person.setLastName(resultSet.getString("lastName"));
            person.setFatherName(resultSet.getString("fatherName"));
            java.util.Date date = resultSet.getTimestamp("birthDate");
            person.setBirthDate(date);
            person.setNationalCode(resultSet.getString("nationalCode"));
            person.setCustomerNumber(resultSet.getString("customerNumber"));
            persons.add(person);
        }
        return persons;
    }

    public List<Person> findByCustomerNumber(String customerNumber){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//        Query query = session.createQuery("from Person p where p.customerNumber = :customerNumber");
//        query.setString("customerNumber", customerNumber);
//        return query.list();
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
