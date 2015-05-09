package com.dotinschool.controller;

import com.dotinschool.model.bl.PersonService;
import com.dotinschool.model.to.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Maral ito on 4/23/2015.
 */
public class SubmitPersonServlet extends HttpServlet {

    private PersonService personService;

    public SubmitPersonServlet() {
        personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Person person = new Person();

            String firstName = request.getParameter("firstName").trim();
            if (firstName.equals("")) {
                forwardToResultPage("وارد کردن نام مشتری اجباری است", request, response, true);
//                generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>First name cannot be empty!</h3>");
//                return;
            }

            String lastName = request.getParameter("lastName").trim();
            if (lastName.equals("")) {
                forwardToResultPage("وارد کردن نام خانوادگی مشتری اجباری است", request, response, true);
//                generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Last name cannot be empty!</h3>");
//                return;
            }

            String fatherName = request.getParameter("fatherName").trim();
            if (fatherName.equals("")) {
                forwardToResultPage("وارد کردن نام پدر اجباری است", request, response, true);
//                generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Father name cannot be empty!</h3>");
//                return;
            }

            String nationalCode = request.getParameter("nationalCode").trim();
            try {
                Double.parseDouble(nationalCode);
            } catch (NumberFormatException e) {
                forwardToResultPage("وارد کردن کد ملی اجباری است", request, response, true);
//                generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Invalid Format for National Code!</h3>");
//                return;
            }

            if (personService.doesExistNationalCode(nationalCode)) {
                forwardToResultPage("این کد ملی قبلا در سیستم ثبت شده است", request, response, true);
//                generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Duplicate National Code!</h3>");
//                return;
            }

            String dateString = request.getParameter("birthDate");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = null;
            try {
                date = format.parse(dateString);
            } catch (ParseException e) {
                forwardToResultPage("فرمت تاریخ نامعتبر است", request, response, true);
//                generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Invalid Date Format!</h3>");
//                return;
            }

            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setFatherName(fatherName);
            person.setNationalCode(nationalCode);
            person.setBirthDate(date);
            person.setCustomerNumber(personService.generateCustomerNumber());
            personService.insertPerson(person);
            forwardToResultPage("مشتری با شماره: " + person.getCustomerNumber() + " با موفقیت ثبت شد", request, response, false);
            forwardToResultPage("مشتری با موفقیت ثبت شد"+ "\n" + "شماره مشتری: " + person.getCustomerNumber(), request, response, false);
//            String message = "Customer Saved! <br /> Customer Number: " + person.getCustomerNumber();
//            generateResultPage(response, "<h3 class='success' dir='ltr' align='center'>" + message + "</h3>");

        } catch (SQLException ex) {
            forwardToResultPage("خطایی در سیستم رخ داده است", request, response, true);
//            generateResultPage(response, "<h3 class='error' dir='ltr' align='center'>Internal Server Error!</h3>");
        }

    }

//    private void generateResultPage(HttpServletResponse response, String body) throws IOException {
//        response.setCharacterEncoding("UTF-8");
//        String html = ResultPageHTML.RESULT_PAGE_TOP + body + ResultPageHTML.RESULT_PAGE_BOTTOM;
//        html = html.replace("RETURN_ADDRESS", "/submitPerson.html");
//        PrintWriter out = response.getWriter();
//        out.println(html);
//        out.flush();
//    }

    private void forwardToResultPage(String message, HttpServletRequest request, HttpServletResponse response, boolean isError) throws ServletException, IOException {
        request.setAttribute("message", message);
        if(isError){
            request.setAttribute("statusClass", "error");
        }
        else{
            request.setAttribute("statusClass", "success");
        }
        response.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

}
