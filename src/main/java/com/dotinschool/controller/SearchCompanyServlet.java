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
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * @author Maral Khojasteh
 */
public class SearchCompanyServlet extends HttpServlet {

    private CompanyService companyService;

    public SearchCompanyServlet(){
        companyService = new CompanyService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String companyName = request.getParameter("companyName");
        String economicCode = request.getParameter("economicCode");
        String customerNumber = request.getParameter("customerNumber");

        try {
            List<Company> companies = companyService.findCompany(companyName, economicCode, customerNumber);
            String body = "";
            if(companies.size() == 0){
                body += "<tr>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "</tr>";
            }
            for(Company company: companies){
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String dateString = format.format(company.getRegistrationDate());
                body += "<tr>\n" +
                        "    <td>" + company.getName() + "</td>\n" +
                        "    <td>" + dateString + "</td>\n" +
                        "    <td>" + company.getEconomicCode() + "</td>\n" +
                        "    <td>" + company.getCustomerNumber()+ "</td>\n" +
                        "    <td><a href='/showCompany?id=" + company.getId() + "&companyName=" + company.getName() + "&registrationDate=" + dateString + "&economicCode=" + company.getEconomicCode() + "&birthDate=" + dateString + "&customerNumber=" + company.getCustomerNumber() + "' dir='rtl' class='link-layout'  style='font-size: small'>ویرایش</a></td>\n" +
                        "    <td><a href='/deleteCompany?id=" + company.getId() + "&companyName=" + companyName + "&economicCode=" + economicCode + "&customerNumber" + customerNumber + "' dir='rtl' class='link-layout'  style='font-size: small'> حذف</a></td>\n" +
                        "</tr>";
            }
            String html = ResultPageHTML.SEARCH_COMPANY_RESULT_PAGE_TOP + body + ResultPageHTML.SEARCH_RESULT_PAGE_BOTTOM;
            generateResultPage(response, html);
        } catch (SQLException e) {
            String html = ResultPageHTML.RESULT_PAGE_TOP + "<h3 class='error' dir='ltr' align='center'>Internal Server Error!</h3>" + ResultPageHTML.RESULT_PAGE_BOTTOM;
            generateResultPage(response, html);
        }

    }
    private void generateResultPage(HttpServletResponse response, String html) throws IOException {
        response.setCharacterEncoding("UTF8");
        html = html.replace("RETURN_ADDRESS", "/searchCompany.html");
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();
    }
}
