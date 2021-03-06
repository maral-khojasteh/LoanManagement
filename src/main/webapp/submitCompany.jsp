<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta charset="UTF-8">
    <title dir="rtl">ثبت مشتری</title>
    <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css"  />
    <link rel="stylesheet" href="css/my-css.css" type="text/css"  />
</head>
<body class="main-background">
    <div id="submitCompanyDiv" class="form-box">
        <div class="form-content">
            <form name="submitCompanyFrm" class="container-fluid" dir="rtl" action="/submitCompany">
                <label dir="rtl">نام شرکت: </label>
                <input type="text" name="companyName" dir="rtl">
                <p dir="rtl"></p>
                <label dir="rtl">تاریخ ثبت: </label>
                <input type="date" name="registrationDate" dir="rtl">
                <p dir="rtl"></p>
                <label dir="rtl">کد اقتصادی: </label>
                <input type="text" name="economicCode" dir="rtl">
                <p dir="rtl"></p>
                <div style="text-align: left">
                    <input type="submit" value="ثبت" class="btn-large btn-inverse">
                </div>
            </form>
        </div>
    </div>
</body>
</html>