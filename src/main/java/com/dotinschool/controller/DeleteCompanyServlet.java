package com.dotinschool.controller;

import com.dotinschool.model.bl.CompanyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @author Maral Khojasteh
 */
public class DeleteCompanyServlet extends HttpServlet {

    private CompanyService companyService;

    public DeleteCompanyServlet() {
        companyService = new CompanyService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        try {
            companyService.deleteCompany(new Long(id));
            generateResultPage(request, response, "<h3 class='success' dir='ltr' align='center'>Customer is deleted successfully</h3>");
        } catch (SQLException e) {
            generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Internal Server Error!</h3>");
        }
    }
    private void generateResultPage(HttpServletRequest request, HttpServletResponse response, String body) throws IOException {
        String companyName = request.getParameter("companyName");
        String economicCode = request.getParameter("economicCode");
        String customerNumber = request.getParameter("customerNumber");
        String html = ResultPageHTML.RESULT_PAGE_TOP + body + ResultPageHTML.RESULT_PAGE_BOTTOM;
        response.setCharacterEncoding("UTF8");
        html = html.replace("RETURN_ADDRESS", "/searchCompany?companyName=" + companyName + "&economicCode=" + economicCode + "&customerNumber" + customerNumber);
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();
    }
}
