<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta charset="UTF-8">
    <title dir="rtl">تشکیل پرونده تسهیلاتی</title>
    <script language="JavaScript" src="js/main.js"></script>
    <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css"  />
    <link rel="stylesheet" href="css/my-css.css" type="text/css"  />
</head>
<body class="main-background container-fluid">
<div class="form-box">
    <div class="error" id="error_id"></div>
    <div class="form-content">
        <form action="/searchCustomer" name="customer_form" class="container-fluid">
            <label dir="rtl">شماره مشتری:</label>
            <input type="button" value="بازیابی" class="btn-small btn-inverse">
            <input type="text" name="customer_number" dir="rtl" id="customer_number_id">
            <p dir="rtl"></p>
            <label dir="rtl">نام و نام خانوادگی:</label>
            <input type="text" name="customer_name" dir="rtl" readonly >
        </form>
        <form action="/submitLoanFile" name="loan_file_form" class="container-fluid">
            <label dir="rtl">نوع تسهیلات:</label>
            <select name="loan_type">
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>
            <p dir="rtl"></p>
            <label dir="rtl">مدت قرارداد:</label>
            <input type="text" name="contract_duration" dir="rtl" id="contract_duration_id">
            <p dir="rtl"></p>
            <label dir="rtl">مبلغ قرارداد:</label>
            <input type="text" name="contract_amount" dir="rtl" id="contract_amount_id">
            <p dir="rtl"></p>
            <div style="text-align: left" >
                <input type="button" value="ثبت" class="btn-large btn-inverse">
            </div>
        </form>
    </div>
</div>

</body>
</html>