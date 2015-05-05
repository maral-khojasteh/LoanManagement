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
public class ShowCompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String companyName = request.getParameter("companyName").trim();
        String registrationDate = request.getParameter("registrationDate").trim();
        String economicCode = request.getParameter("economicCode").trim();
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
                        "        <form name=\"submitPersonFrm\" class=\"container-fluid\" dir=\"rtl\" action=\"/editCompany\">\n" +
                        "            <input type=\"hidden\" name=\"id\" value=\"" + id +
                        "            \">\n" +
                        "            <input type=\"hidden\" name=\"customerNumberHidden\" value=\"" + customerNumber +
                        "            \">\n" +
                        "            <input type=\"hidden\" name=\"economicCodeHidden\" value=\"" + economicCode +
                        "            \">\n" +
                        "            <input type=\"hidden\" name=\"companyNameHidden\" value=\"" + companyName +
                        "            \">\n" +
                        "            <input type=\"hidden\" name=\"registrationDateHidden\" value=\"" + registrationDate +
                        "            \">\n" +
                        "            <label dir=\"rtl\">شماره مشتری: </label>\n" +
                        "            <input type=\"text\" name=\"customerNumber\" dir=\"rtl\" disabled value=\"" + customerNumber +
                        "            \">\n" +
                        "            <p dir=\"rtl\"></p>\n" +
                        "            <label dir=\"rtl\">نام شرکت: </label>"  +
                        "            <input type=\"text\" name=\"companyName\" dir=\"rtl\" value=\"" + companyName +
                        "            \">\n" +
                        "            <p dir=\"rtl\"></p>\n" +
                        "            <label dir=\"rtl\">تاریخ ثبت: </label>" +
                        "            <input type=\"text\" name=\"registrationDate\" dir=\"rtl\" value=\"" + registrationDate +
                        "            \">\n" +
                        "            <p dir=\"rtl\"></p>\n" +
                        "            <label dir=\"rtl\">کد اقتصادی: </label>" +
                        "            <input type=\"text\" name=\"economicCode\" dir=\"rtl\" value=\"" + economicCode +
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
