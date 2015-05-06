<%@ page import="com.dotinschool.model.to.LoanType" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta charset="UTF-8">
    <title dir="rtl">تشکیل پرونده تسهیلاتی</title>
    <script language="JavaScript" src="js/main.js"></script>
    <link rel="stylesheet" href="css/my-css.css" type="text/css"  />
    <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css"  />
</head>
<body class="main-background container-fluid">
<div class="form-box">
    <div class="<% out.print(request.getAttribute("statusClass"));%>" id="error_id">
        <p dir="rtl" align="center"><%= request.getAttribute("message")!= null ? request.getAttribute("message") : ""%></p>
    </div>
    <div class="form-content">
        <form action="/searchCustomer" name="customer_form">
            <label dir="rtl">شماره مشتری:</label>
            <div dir="rtl">
                <input type="text" name="customer_number" class="form-control" dir="rtl" id="customer_number_id" style="vertical-align: top;" value="<%= request.getAttribute("customerNumber") != null ? request.getAttribute("customerNumber") : ""%>">
                <input type="submit" value="بازیابی" class="btn-small btn-inverse">
            </div>
            <p dir="rtl"></p>
            <label dir="rtl">نام و نام خانوادگی:</label>
            <input type="text" name="customer_name" class="form-input-wide" dir="rtl" readonly value="<%=request.getAttribute("customerName")!= null ? request.getAttribute("customerName") : ""%>">
        </form>
        <form action="/submitLoanFile" name="loan_file_form" class="container-fluid">
            <input type="hidden" name="customer_id" value="<%= request.getAttribute("customerId")!= null ? request.getAttribute("customerId") : ""%>">
            <label dir="rtl">نوع تسهیلات:</label>
            <select name="loan_type" class="form-input-wide">
                <%
                    List<LoanType> loanTypes = (List<LoanType>) request.getAttribute("loanTypes");
                    for(LoanType loanType: loanTypes) { %>
                <option value="<%= loanType.getId()%>"
                        <%
                            if(request.getAttribute("selectedId") != null){
                                long selectedId = Long.valueOf((String) request.getAttribute("selectedId"));
                                if (loanType.getId() == selectedId) {
                                    out.write("selected");
                                }
                            }
                        %>
                    ><%= loanType.getName()%></option>
                <% } %>
            </select>
            <p dir="rtl"></p>
            <label dir="rtl">مدت قرارداد:</label>
            <input type="text" class="form-input-wide" name="contract_duration" dir="rtl" id="contract_duration_id" value="<%=request.getAttribute("duration")!= null ? request.getAttribute("duration") : ""%>">
            <p dir="rtl"></p>
            <label dir="rtl">مبلغ قرارداد:</label>
            <input type="text" name="contract_amount" class="form-input-wide" dir="rtl" id="contract_amount_id" value="<%=request.getAttribute("amount")!= null ? request.getAttribute("amount") : ""%>">
            <p dir="rtl"></p>
            <div style="text-align: left" >
                <input type="button" value="ثبت" class="btn-large btn-inverse" onclick="validateLoanFileValue()" <%=request.getAttribute("disabled")== null ? "disabled" : request.getAttribute("disabled")%> >
            </div>
        </form>
    </div>
</div>

</body>
</html>