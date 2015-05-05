package com.dotinschool.controller;

import com.dotinschool.model.bl.PersonService;

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
public class DeletePersonServlet extends HttpServlet {

    private PersonService personService;

    public DeletePersonServlet() {
        personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        try {
            personService.deletePerson(new Long(id));
            generateResultPage(request, response, "<h3 class='success' dir='ltr' align='center'>Customer is deleted successfully</h3>");
        } catch (SQLException e) {
            generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Internal Server Error!</h3>");
        }
    }
    private void generateResultPage(HttpServletRequest request, HttpServletResponse response, String body) throws IOException {
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String nationalCode = request.getParameter("nationalCode").trim();
        String customerNumber = request.getParameter("customerNumber").trim();
        String html = ResultPageHTML.RESULT_PAGE_TOP + body + ResultPageHTML.RESULT_PAGE_BOTTOM;
        response.setCharacterEncoding("UTF8");
        html = html.replace("RETURN_ADDRESS", "/searchPerson?firstName=" + firstName + "&lastName=" + lastName + "&nationalCode=" + nationalCode + "&customerNumber" + customerNumber);
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();
    }
}
