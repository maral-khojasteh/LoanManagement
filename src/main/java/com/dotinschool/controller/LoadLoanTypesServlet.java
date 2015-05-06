package com.dotinschool.controller;

import com.dotinschool.model.bl.LoanTypeService;
import com.dotinschool.model.to.LoanType;

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
public class LoadLoanTypesServlet extends HttpServlet {

    private LoanTypeService loanTypeService;

    public LoadLoanTypesServlet(){
        loanTypeService = new LoanTypeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<LoanType> loanTypes = loanTypeService.findAll();
        request.setAttribute("loanTypes", loanTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/loans_file.jsp");
        dispatcher.forward(request, response);
    }
}
