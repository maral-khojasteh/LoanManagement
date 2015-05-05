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
public class EditCompanyServlet extends HttpServlet {

    private CompanyService companyService;

    public EditCompanyServlet() {
        companyService = new CompanyService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Company company = new Company();

            long id = new Long(request.getParameter("id").trim());
            String customerNumber = request.getParameter("customerNumberHidden").trim();
            String baseEconomicCode = request.getParameter("economicCodeHidden").trim();

            String companyName = request.getParameter("companyName").trim();
            if (companyName.equals("")) {
                generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Company name cannot be empty!</h3>", true);
                return;
            }

            String economicCode = request.getParameter("economicCode").trim();
            try {
                Double.parseDouble(economicCode);
            } catch (NumberFormatException e) {
                generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Invalid Format for Economic Code!</h3>", true);
                return;
            }

            if (companyService.doesExistEconomicCode(economicCode) && !(economicCode.equals(baseEconomicCode))) {
                generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Duplicate Economic Code!</h3>", true);
                return;
            }

            String dateString = request.getParameter("registrationDate");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = null;
            try {
                date = format.parse(dateString);
            } catch (ParseException e) {
                generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Invalid Date Format!</h3>", true);
                return;
            }

            company.setId(id);
            company.setName(companyName);
            company.setEconomicCode(economicCode);
            company.setRegistrationDate(date);
            companyService.editCompany(company);
            String message = "Customer " + customerNumber + " is edited successfully";
            generateResultPage(request, response, "<h3 class='success' dir='ltr' align='center'>" + message + "</h3>", false);
        }catch (SQLException e){
            generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Internal Server Error!</h3>", true);
        }
    }

    private void generateResultPage(HttpServletRequest request, HttpServletResponse response, String body, boolean isError) throws IOException {
        long id = new Long(request.getParameter("id").trim());
        String customerNumber = request.getParameter("customerNumberHidden").trim();
        String baseCompanyName = request.getParameter("companyNameHidden").trim();
        String baseRegistrationDate = request.getParameter("registrationDateHidden").trim();
        String baseEconomicCode = request.getParameter("economicCodeHidden").trim();
        String companyName = request.getParameter("companyName").trim();
        String registrationDate = request.getParameter("registrationDate").trim();
        String economicCode = request.getParameter("economicCode").trim();
        response.setCharacterEncoding("UTF-8");
        String html = ResultPageHTML.RESULT_PAGE_TOP + body + ResultPageHTML.RESULT_PAGE_BOTTOM;
        //html = html.replace("RETURN_ADDRESS", "/searchPerson?firstName=" + baseFirstName + "&lastName=" + baseLastName + "&nationalCode=" + nationalCode + "&customerNumber=" + customerNumber);
        if(isError){
            html = html.replace("RETURN_ADDRESS", "/showCompany?id=" + id + "&companyName=" + baseCompanyName + "&registrationDate=" + baseRegistrationDate + "&economicCode=" + baseEconomicCode + "&customerNumber=" + customerNumber);
        }
        else{
            html = html.replace("RETURN_ADDRESS", "/showCompany?id=" + id + "&companyName=" + companyName + "&registrationDate=" + registrationDate + "&economicCode=" + economicCode + "&customerNumber=" + customerNumber);
        }
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();
    }
}
