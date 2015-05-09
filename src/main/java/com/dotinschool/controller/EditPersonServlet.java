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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Maral Khojasteh
 */
public class EditPersonServlet extends HttpServlet {

    private PersonService personService;

    public EditPersonServlet() {
        personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Person person = new Person();

            long id = new Long(request.getParameter("id").trim());
            String customerNumber = request.getParameter("customerNumberHidden").trim();
            String baseNationalCode = request.getParameter("nationalCodeHidden").trim();

            String firstName = request.getParameter("firstName").trim();
            if (firstName.equals("")) {
                generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>First name cannot be empty!</h3>", true);
                return;
            }

            String lastName = request.getParameter("lastName").trim();
            if (lastName.equals("")) {
                generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Last name cannot be empty!</h3>", true);
                return;
            }

            String fatherName = request.getParameter("fatherName").trim();
            if (fatherName.equals("")) {
                generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Father name cannot be empty!</h3>", true);
                return;
            }

            String nationalCode = request.getParameter("nationalCode").trim();
            try {
                Double.parseDouble(nationalCode);
            } catch (NumberFormatException e) {
                generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Invalid Format for National Code!</h3>", true);
                return;
            }

            if (personService.doesExistNationalCode(nationalCode) && !(nationalCode.equals(baseNationalCode))) {
                generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Duplicate National Code!</h3>", true);
                return;
            }

            String dateString = request.getParameter("birthDate");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = null;
            try {
                date = format.parse(dateString);
            } catch (ParseException e) {
                generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Invalid Date Format!</h3>", true);
                return;
            }

            person.setId(id);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setFatherName(fatherName);
            person.setNationalCode(nationalCode);
            person.setBirthDate(date);
            person.setCustomerNumber(customerNumber);
            personService.editPerson(person);
            String message = "Customer " + customerNumber + " is edited successfully";
            generateResultPage(request, response, "<h3 class='success' dir='ltr' align='center'>" + message + "</h3>", false);
        }catch (SQLException e){
            generateResultPage(request, response, "<h3 class='error' dir='ltr' align='center'>Internal Server Error!</h3>", true);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }

    private void generateResultPage(HttpServletRequest request, HttpServletResponse response, String body, boolean isError) throws IOException {
        long id = new Long(request.getParameter("id").trim());
        String customerNumber = request.getParameter("customerNumberHidden").trim();
        String baseFirstName = request.getParameter("firstNameHidden").trim();
        String baseLastName = request.getParameter("lastNameHidden").trim();
        String baseFatherName = request.getParameter("fatherNameHidden").trim();
        String baseBirthDate = request.getParameter("birthDateHidden").trim();
        String baseNationalCode = request.getParameter("nationalCodeHidden").trim();
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String fatherName = request.getParameter("fatherName").trim();
        String birthDate = request.getParameter("birthDate").trim();
        String nationalCode = request.getParameter("nationalCode").trim();
        response.setCharacterEncoding("UTF-8");
        String html = ResultPageHTML.RESULT_PAGE_TOP + body + ResultPageHTML.RESULT_PAGE_BOTTOM;
        //html = html.replace("RETURN_ADDRESS", "/searchPerson?firstName=" + baseFirstName + "&lastName=" + baseLastName + "&nationalCode=" + nationalCode + "&customerNumber=" + customerNumber);
        if(isError){
            html = html.replace("RETURN_ADDRESS", "/showPerson?id=" + id + "&firstName=" + baseFirstName + "&lastName=" + baseLastName + "&fatherName=" + baseFatherName + "&birthDate=" + baseBirthDate + "&nationalCode=" + baseNationalCode + "&customerNumber=" + customerNumber);
        }
        else{
            html = html.replace("RETURN_ADDRESS", "/showPerson?id=" + id + "&firstName=" + firstName + "&lastName=" + lastName + "&fatherName=" + fatherName + "&birthDate=" + birthDate + "&nationalCode=" + nationalCode + "&customerNumber=" + customerNumber);
        }
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();
    }
}
