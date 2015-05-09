package com.dotinschool.model.bl;

import com.dotinschool.model.dao.PersonDAO;
import com.dotinschool.model.to.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Maral ito on 4/23/2015.
 */
public class PersonService extends CustomerService{

    private PersonDAO personDAO;

    public PersonService() {
        personDAO = new PersonDAO();
    }

    public void insertPerson(Person person) throws SQLException {
        personDAO.save(person);
    }

    public void editPerson(Person person) throws SQLException {
        personDAO.save(person);
    }

    public void deletePerson(long personId) throws SQLException {
        personDAO.delete(personId);
    }

    public boolean doesExistNationalCode(String nationalCode) throws SQLException {
        return personDAO.doesExistNationalCode(nationalCode);
    }

    public List<Person> findPerson(String firstName, String lastName, String nationalCode, String customerNumber) throws SQLException {
        return personDAO.find(firstName, lastName, nationalCode, customerNumber);
    }

    public List<Person> findByCustomerNumber(String customerNumber){
        return personDAO.findByCustomerNumber(customerNumber);
    }

    public Person findById(Long id){
        return personDAO.findById(id);
    }
//    public void closeConnection() throws Exception {
//        personDAO.close();
//    }
}
