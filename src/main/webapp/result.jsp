<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head lang="en">
        <meta charset="UTF-8">
        <title dir="rtl">پیغام سیستم</title>
        <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css"  />
        <link rel="stylesheet" href="css/my-css.css" type="text/css"  />
    </head>
    <body class="main-background container-fluid">

        <div class="main-box" dir="rtl">
            <br/><br/>
            <h3 class="<% out.print(request.getAttribute("statusClass"));%>" dir="rtl" align='center'><% out.print(request.getAttribute("message"));%></h3>
        </div>

    </body>
</html>