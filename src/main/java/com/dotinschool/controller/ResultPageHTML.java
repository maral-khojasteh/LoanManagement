package com.dotinschool.controller;

/**
 * Created by Maral ito on 4/25/2015.
 */
public class ResultPageHTML {

    public static final String RESULT_PAGE_TOP =
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                    "<head lang=\"en\">\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>پیغام سیستم</title>\n" +
                    "    <link rel=\"stylesheet\" href=\"assets/css/bootstrap.css\" type=\"text/css\"  />\n" +
                    "    <link rel=\"stylesheet\" href=\"css/my-css.css\" type=\"text/css\"  />\n" +
                    "</head>\n" +
                    "<body class=\"main-background container-fluid\">\n" +
                    "\n" +
                    "   <div class=\"main-box\" dir=\"rtl\">\n";

    public static final String RESULT_PAGE_BOTTOM =
             "<br /><br />" +
             "<div text-align='center'><a href='RETURN_ADDRESS'>" +
             "بازگشت" +
             "</a></div>" +
             "</div>\n" +
             "</body>\n" +
             "</html>";

    public static final String SEARCH_PERSON_RESULT_PAGE_TOP = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"+
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"+
            "<head lang=\"en\">\n"+
            "    <meta charset=\"UTF-8\">\n"+
            "    <title dir=\"rtl\">نتایج جستجو</title>\n"+
            "    <link rel=\"stylesheet\" href=\"assets/css/bootstrap.css\" type=\"text/css\"  />\n"+
            "    <link rel=\"stylesheet\" href=\"css/my-css.css\" type=\"text/css\"  />\n"+
            "</head>\n"+
            "<body class=\"main-background\">\n"+
            "    <table class='table-layout' border='4' >\n"+
            "        <tr bgcolor=\"lightsteelblue\">\n"+
            "            <td>نام</td>\n"+
            "            <td>نام خانوادگی</td>\n"+
            "            <td>نام پدر</td>\n"+
            "            <td>تاریخ تولد</td>\n"+
            "            <td>کد ملی</td>\n"+
            "            <td>شماره مشتری</td>\n"+
            "            <td class=\"icon-update\"></td>\n"+
            "            <td class=\"icon-remove\"></td>\n"+
            "        </tr>";

    public static final String SEARCH_COMPANY_RESULT_PAGE_TOP = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"+
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"+
            "<head lang=\"en\">\n"+
            "    <meta charset=\"UTF-8\">\n"+
            "    <title dir=\"rtl\">نتایج جستجو</title>\n"+
            "    <link rel=\"stylesheet\" href=\"assets/css/bootstrap.css\" type=\"text/css\"  />\n"+
            "    <link rel=\"stylesheet\" href=\"css/my-css.css\" type=\"text/css\"  />\n"+
            "</head>\n"+
            "<body class=\"main-background\">\n"+
            "    <table class='table-layout' border='4'>\n"+
            "        <tr bgcolor=\"lightsteelblue\">\n"+
            "            <td>نام شرکت</td>\n"+
            "            <td>تاریخ ثبت</td>\n"+
            "            <td>کد اقتصادی</td>\n"+
            "            <td>شماره مشتری</td>\n"+
            "            <td class=\"icon-update\"></td>\n"+
            "            <td class=\"icon-remove\"></td>\n"+
            "        </tr>";

    public static final String SEARCH_RESULT_PAGE_BOTTOM =
            "</table>" +
                    "<br /><br />" +
                    "<div text-align='center'><a href='RETURN_ADDRESS' class='link-layout'>" +
                    "بازگشت" +
                    "</a></div>" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";

}
