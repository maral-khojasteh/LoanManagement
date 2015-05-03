<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head lang="en">
        <meta charset="UTF-8">
        <title dir="rtl">ثبت شروط اعطا</title>
        <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css"  />
        <link rel="stylesheet" href="css/my-css.css" type="text/css"  />
    </head>
    <body class="main-background container-fluid">
        <div class="form-box2">
            <div class="form-content">
                <form class="container-fluid" dir="rtl" action="/submitLoanType">
                    <label dir="rtl">نام:</label>
                    <input type="text" name="condition_name" dir="rtl">
                    <p dir="rtl"></p>
                    <label dir="rtl">حداقل مدت قرارداد:</label>
                    <input type="text" name="minimum_days" dir="rtl">
                    <p dir="rtl"></p>
                    <label dir="rtl">حداکثر مدت قرارداد:</label>
                    <input type="text" name="maximum_days" dir="rtl">
                    <p dir="rtl"></p>
                    <label dir="rtl">حداقل مبلغ قرارداد:</label>
                    <input type="text" name="minimum_amount" dir="rtl">
                    <p dir="rtl"></p>
                    <label dir="rtl">حداکثر مبلغ قرارداد:</label>
                    <input type="text" name="maximum_amount" dir="rtl">
                    <p dir="rtl"></p>
                    <div style="text-align: left">
                        <input type="submit" value="ثبت"  class="btn-large btn-inverse">
                    </div>
                </form>
            </div>
        </div>
        <br/><br/>
        <div>
            <table class="table-layout" border="4">
                <tr bgcolor="#b0c4de">
                    <td>نام</td>
                    <td>حداقل مدت قرارداد</td>
                    <td>حداکثر مدت قرارداد</td>
                    <td>حداقل مبلغ قرارداد</td>
                    <td>حداکثر مبلغ قرارداد</td>
                </tr>
            </table>
            <p dir="rtl"></p>
            <div style="text-align: left">
                <input type="submit" value="ثبت نهایی"  class="btn-large btn-inverse">
            </div>
        </div>
    </body>
</html>
