package com.dotinschool.controller;

import com.dotinschool.model.bl.LoanTypeService;
import com.dotinschool.model.bl.PersonService;
import com.dotinschool.model.to.LoanType;
import com.dotinschool.model.to.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Maral Khojasteh
 */
public class SearchCustomerServlet extends HttpServlet {

    private PersonService personService;
    private LoanTypeService loanTypeService;

    public SearchCustomerServlet(){
        personService = new PersonService();
        loanTypeService = new LoanTypeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String customerNumber = request.getParameter("customer_number").trim();
        List<Person> persons = personService.findByCustomerNumber(customerNumber);
        //TODO is there any way to setAttribute loanTypes in loan_files.jsp without calling findAll again?!!
        List<LoanType> loanTypes = loanTypeService.findAll();
        request.setAttribute("loanTypes", loanTypes);
        request.setAttribute("customerNumber", customerNumber);
        if(persons.size()>0){
            request.setAttribute("customerName", persons.get(0).getFirstName() + " " + persons.get(0).getLastName());
            request.setAttribute("customerId",persons.get(0).getId());
            request.setAttribute("disabled", "");
        }
        else{
            request.setAttribute("message", "شخصی با چنین شماره مشتری در سیستم یافت نشد");
            request.setAttribute("statusClass", "error");
            request.setAttribute("disabled", "disabled");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/loans_file.jsp");
        dispatcher.forward(request, response);
    }

}
