<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.dotinschool.model.to.LoanType" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta charset="UTF-8">
    <title dir="rtl">ورود به سامانه</title>
    <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css"  />
    <link rel="stylesheet" href="css/my-css.css" type="text/css"  />
</head>
<body class="main-background container-fluid">

   <div class="main-box" dir="rtl">
       <h3 style="font-family: tahoma" dir="rtl" align="center">سسامانه ی اعطای تسهیلات</h3>
       <div class="center">

           <table>

               <% List<LoanType> loanTypes = (List<LoanType>) request.getAttribute("loanTypes"); %>
               <% out.println();%>
               <% for(LoanType loanType: loanTypes) { %>
                    <tr>
                        <td>
                            <%= loanType.getName() %>
                        </td>
                        <td>
                            <%= loanType.getInterestRate() %>
                        </td>
                    </tr>
               <% } %>

           </table>



       </div>
   </div>

</body>
</html>