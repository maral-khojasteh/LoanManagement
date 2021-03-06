<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta charset="UTF-8">
    <title dir="rtl">ثبت مشتری</title>
    <script language="JavaScript" src="js/main.js"></script>
    <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css"  />
    <link rel="stylesheet" href="css/my-css.css" type="text/css"  />
</head>
<body class="main-background">
    <div id="submitPersonDiv" class="form-box">
        <div class="form-content">
            <form name="submitPersonFrm" class="container-fluid" dir="rtl" action="/submitPerson">
                <label dir="rtl">نام: </label>
                <input type="text" name="firstName" dir="rtl">
                <p dir="rtl"></p>
                <label dir="rtl">نام خانوادگی: </label>
                <input type="text" name="lastName" dir="rtl">
                <p dir="rtl"></p>
                <label dir="rtl">نام پدر: </label>
                <input type="text" name="fatherName" dir="rtl">
                <p dir="rtl"></p>
                <label dir="rtl">تاریخ تولد: </label>
                <input type="date" name="birthDate" dir="rtl">
                <p dir="rtl"></p>
                <label dir="rtl">کد ملی: </label>
                <input type="text" name="nationalCode" dir="rtl" id="national_code_id">
                <p dir="rtl"></p>
                <div style="text-align: left">
                    <input type="button" value="ثبت"  class="btn-large btn-inverse" onclick="validateNationalCode()">
                </div>
            </form>
        </div>
    </div>
</body>
</html>