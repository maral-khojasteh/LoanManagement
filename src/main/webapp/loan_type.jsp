<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head lang="en">
        <meta charset="UTF-8">
        <title dir="rtl">ثبت نوع تسهیلات</title>
        <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css"  />
        <link rel="stylesheet" href="css/my-css.css" type="text/css"  />
    </head>
    <body class="main-background container-fluid">

        <div class="form-box">
            <div class="form-content">
                <form class="container-fluid" dir="rtl" action="/submitLoanType">
                    <label dir="rtl">نام نوع تسهیلات:</label>
                    <input type="text" name="loan_type_name" dir="rtl">
                    <p dir="rtl"></p>
                    <label dir="rtl">نرخ سود:</label>
                    <input type="text" name="interest_rate" dir="rtl">
                    <p dir="rtl"></p>
                    <div style="text-align: left">
                        <input type="submit" value="ثبت"  class="btn-large btn-inverse">
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>