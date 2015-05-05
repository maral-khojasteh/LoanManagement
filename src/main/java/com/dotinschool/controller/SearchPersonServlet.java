package com.dotinschool.controller;

import com.dotinschool.model.bl.PersonService;
import com.dotinschool.model.to.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @author Maral Khojasteh
 */
public class SearchPersonServlet  extends HttpServlet {

    private PersonService personService;

    public SearchPersonServlet(){
        personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String nationalCode = request.getParameter("nationalCode").trim();
        String customerNumber = request.getParameter("customerNumber").trim();

        try {
            ArrayList<Person> persons = personService.findPerson(firstName, lastName, nationalCode, customerNumber);
            String body = "";
            if(persons.size() == 0){
                body += "<tr>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "    <td></td>\n" +
                        "</tr>";

            }
            for(Person person: persons){
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String dateString = format.format(person.getBirthDate());
                body += "<tr>\n" +
                    "    <td>" + person.getFirstName() + "</td>\n" +
                    "    <td>" + person.getLastName() + "</td>\n" +
                    "    <td>" + person.getFatherName() + "</td>\n" +
                    "    <td>" + dateString + "</td>\n" +
                    "    <td>" + person.getNationalCode() + "</td>\n" +
                    "    <td>" + person.getCustomerNumber()+ "</td>\n" +
                    "    <td><a href='/showPerson?id=" + person.getId() + "&firstName=" + person.getFirstName() + "&lastName=" + person.getLastName() + "&fatherName=" + person.getFatherName() + "&birthDate=" + dateString + "&nationalCode=" + person.getNationalCode() + "&customerNumber=" + person.getCustomerNumber() + "' dir='rtl' class='link-layout' style='font-size: small'>ویرایش</a></td>\n" +
                    "    <td><a href='/deletePerson?id=" + person.getId() + "&firstName=" + firstName + "&lastName=" + lastName + "&nationalCode=" + nationalCode + "&customerNumber" + customerNumber + "' dir='rtl' class='link-layout'  style='font-size: small'> حذف</a></td>\n" +
                        "</tr>";
            }
            String html = ResultPageHTML.SEARCH_PERSON_RESULT_PAGE_TOP + body + ResultPageHTML.SEARCH_RESULT_PAGE_BOTTOM;
            generateResultPage(response, html);
        } catch (SQLException e) {
            String html = ResultPageHTML.RESULT_PAGE_TOP + "<h3 class='error' dir='ltr' align='center'>Internal Server Error!</h3>" + ResultPageHTML.RESULT_PAGE_BOTTOM;
            generateResultPage(response, html);
        }
    }

    private void generateResultPage(HttpServletResponse response, String html) throws IOException {
        response.setCharacterEncoding("UTF8");
        html = html.replace("RETURN_ADDRESS", "/searchPerson.html");
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();
    }
}
