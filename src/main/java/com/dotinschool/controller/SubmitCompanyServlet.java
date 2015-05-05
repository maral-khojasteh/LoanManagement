package com.dotinschool.controller;

import com.dotinschool.model.bl.CompanyService;
import com.dotinschool.model.to.Company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Maral Khojasteh
 */
public class SubmitCompanyServlet extends HttpServlet {

    private CompanyService companyService;

    public SubmitCompanyServlet() {
        companyService = new CompanyService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Company company = new Company();

            String companyName = request.getParameter("companyName").trim();
            if (companyName.equals("")) {
                generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Company name cannot be empty!</h3>");
                return;
            }

            String registrationDateString = request.getParameter("registrationDate");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = null;
            try {
                date = format.parse(registrationDateString);
            } catch (ParseException e) {
                generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Invalid Date Format!</h3>");
                return;
            }

            String economicCode = request.getParameter("economicCode").trim();
            try {
                Double.parseDouble(economicCode);
            } catch (NumberFormatException e) {
                generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Invalid Format for Economic Code!</h3>");
                return;
            }

            if (companyService.doesExistEconomicCode(economicCode)) {
                generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Duplicate Economic Code!</h3>");
                return;
            }

            company.setName(companyName);
            company.setEconomicCode(economicCode);
            company.setRegistrationDate(date);
            company.setCustomerNumber(companyService.generateCustomerNumber());
            companyService.insertCompany(company);
            String message = "Customer Saved! <br /> Customer Number: " + company.getCustomerNumber();
            generateResultPage(response, "<h3 class='success' dir='ltr' align='center'>" + message + "</h3>");
        }catch (SQLException e){
            generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Internal Server Error!</h3>");
        }
    }

    private void generateResultPage(HttpServletResponse response, String body) throws IOException {
        response.setCharacterEncoding("UTF8");
        String html = ResultPageHTML.RESULT_PAGE_TOP + body + ResultPageHTML.RESULT_PAGE_BOTTOM;
        html.replace("RETURN_ADDRESS", "/submitCompany.html");
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();
    }
}

