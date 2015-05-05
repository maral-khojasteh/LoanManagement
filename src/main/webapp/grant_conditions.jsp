<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head lang="en">
        <meta charset="UTF-8">
        <title dir="rtl">ثبت شروط اعطا</title>
        <script language="JavaScript" src="js/main.js"></script>
        <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css"  />
        <link rel="stylesheet" href="css/my-css.css" type="text/css"  />
    </head>
    <body class="main-background container-fluid">
        <div class="form-box2">
            <div class="error" id="error_id"></div>
            <div class="form-content">
                <%--<form class="container-fluid" dir="rtl" name="grant_condition_form">--%>
                    <label dir="rtl">نام:</label>
                    <input type="text" name="condition_name" dir="rtl" id="condition_name_id">
                    <p dir="rtl"></p>
                    <label dir="rtl">حداقل مدت قرارداد:</label>
                    <input type="text" name="minimum_days" dir="rtl" id="minimum_days_id">
                    <p dir="rtl"></p>
                    <label dir="rtl">حداکثر مدت قرارداد:</label>
                    <input type="text" name="maximum_days" dir="rtl" id="maximum_days_id">
                    <p dir="rtl"></p>
                    <label dir="rtl">حداقل مبلغ قرارداد:</label>
                    <input type="text" name="minimum_amount" dir="rtl" id="minimum_amount_id">
                    <p dir="rtl"></p>
                    <label dir="rtl">حداکثر مبلغ قرارداد:</label>
                    <input type="text" name="maximum_amount" dir="rtl" id="maximum_amount_id">
                    <p dir="rtl"></p>
                    <div style="text-align: left">
                        <button   class="btn-large btn-inverse" onclick="addCondition()">ثبت</button>
                        <%--<input type="button" value="ثبت"  class="btn-large btn-inverse" onclick="addCondition()">--%>
                    </div>
                <%--</form>--%>
            </div>
        </div>
        <div>
            <form action="/submitLoanType">
                <input type="hidden" name="loan_type_name" value="<% out.print(request.getParameter("loan_type_name"));%>"/>
                <input type="hidden" name="interest_rate" value="<% out.print(request.getParameter("interest_rate"));%>"/>
                <input type="hidden" name="row_count" id="row_count_id"/>
                <table class="table-layout2" border="4" id="conditionsTableId">
                    <tr bgcolor="#b0c4de">
                        <td style="text-align: center" width="110px">حداکثر مبلغ قرارداد</td>
                        <td style="text-align: center" width="110px">حداقل مبلغ قرارداد</td>
                        <td style="text-align: center" width="110px">حداکثر مدت قرارداد</td>
                        <td style="text-align: center" width="110px">حداقل مدت قرارداد</td>
                        <td style="text-align: center" width="100px">نام</td>
                    </tr>
                </table>
                <p dir="rtl"></p>
                <div style="text-align: center" >
                    <input type="submit" value="ثبت نهایی"  class="btn-large btn-inverse">
            </div>
            </form>
        </div>
    </body>
</html>
