<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head lang="en">
        <meta charset="UTF-8">
        <title dir="rtl">ثبت نوع تسهیلات</title>
        <script language="JavaScript" src="js/main.js"></script>
        <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css"  />
        <link rel="stylesheet" href="css/my-css.css" type="text/css"  />
    </head>
    <body class="main-background container-fluid">

        <div class="form-box">
            <div class="error" id="error_id"></div>
            <div class="form-content">
                <%--<form class="container-fluid" dir="rtl" action="/submitLoanType">--%>
                <form name="loan_type_form" class="container-fluid" dir="rtl" action="/grant_conditions.jsp">
                    <label dir="rtl">نام نوع تسهیلات:</label>
                    <input type="text" name="loan_type_name" dir="rtl">
                    <p dir="rtl"></p>
                    <label dir="rtl">نرخ سود:</label>
                    <input type="text" name="interest_rate" dir="rtl">
                    <p dir="rtl"></p>
                    <div style="text-align: left">
                        <input type="button" value="ثبت"  class="btn-large btn-inverse" onclick="validateLoanType()">
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>