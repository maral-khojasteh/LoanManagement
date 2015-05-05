package com.dotinschool.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Maral Khojasteh
 */
public class ShowPersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String fatherName = request.getParameter("fatherName").trim();
        String nationalCode = request.getParameter("nationalCode").trim();
        String birthDate = request.getParameter("birthDate");
        String customerNumber = request.getParameter("customerNumber").trim();
        long id = new  Long(request.getParameter("id"));
        String html =
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head lang=\"en\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title dir=\"rtl\">ویرایش مشتری</title>\n" +
                "    <link rel=\"stylesheet\" href=\"assets/css/bootstrap.css\" type=\"text/css\"  />\n" +
                "    <link rel=\"stylesheet\" href=\"css/my-css.css\" type=\"text/css\"  />\n" +
                "</head>\n" +
                "<body class=\"main-background\">\n" +
                "<div id=\"submitPersonDiv\" class=\"form-box\">\n" +
                "    <div class=\"form-content\">\n" +
                "        <form name=\"submitPersonFrm\" class=\"container-fluid\" dir=\"rtl\" method=\"post\" action='/editPerson'    >\n" +
                "            <input type=\"hidden\" name=\"id\" value=\"" + id +
                "            \">\n" +
                "            <input type=\"hidden\" name=\"customerNumberHidden\" value=\"" + customerNumber +
                "            \">\n" +
                "            <input type=\"hidden\" name=\"nationalCodeHidden\" value=\"" + nationalCode +
                "            \">\n" +
                "            <input type=\"hidden\" name=\"firstNameHidden\" value=\"" + firstName +
                "            \">\n" +
                "            <input type=\"hidden\" name=\"lastNameHidden\" value=\"" + lastName +
                "            \">\n" +
                "            <input type=\"hidden\" name=\"fatherNameHidden\" value=\"" + fatherName +
                "            \">\n" +
                "            <input type=\"hidden\" name=\"birthDateHidden\" value=\"" + birthDate +
                "            \">\n" +
                "            <label dir=\"rtl\">شماره مشتری: </label>\n" +
                "            <input type=\"text\" name=\"customerNumber\" dir=\"rtl\" disabled value=\"" + customerNumber +
                "            \">\n" +
                "            <p dir=\"rtl\"></p>\n" +
                "            <label dir=\"rtl\">نام: </label>\n" +
                "            <input type=\"text\" name=\"firstName\" dir=\"rtl\" value=\"" + firstName +
                "            \">\n" +
                "            <p dir=\"rtl\"></p>\n" +
                "            <label dir=\"rtl\">نام خانوادگی: </label>\n" +
                "            <input type=\"text\" name=\"lastName\" dir=\"rtl\" value=\"" + lastName +
                "            \">\n" +
                "            <p dir=\"rtl\"></p>\n" +
                "            <label dir=\"rtl\">نام پدر: </label>\n" +
                "            <input type=\"text\" name=\"fatherName\" dir=\"rtl\" value=\"" + fatherName +
                "            \">\n" +
                "            <p dir=\"rtl\"></p>\n" +
                "            <label dir=\"rtl\">تاریخ تولد: </label>\n" +
                "            <input type=\"text\" name=\"birthDate\" dir=\"rtl\" value=\"" + birthDate +
                "            \">\n" +
                "            <p dir=\"rtl\"></p>\n" +
                "            <label dir=\"rtl\">کد ملی: </label>\n" +
                "            <input type=\"text\" name=\"nationalCode\" dir=\"rtl\" value=\"" + nationalCode +
                "            \">\n" +
                "            <p dir=\"rtl\"></p>\n" +
                "            <div style=\"text-align: left\">\n" +
                "                <input type=\"submit\" value=\"ثبت\"  class=\"btn-large btn-inverse\">\n" +
                "            </div>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        response.setCharacterEncoding("UTF8");
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();
    }
}
