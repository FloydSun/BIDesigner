<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BI demo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/build/css/login_styles.css">
    <style>

        input:-webkit-autofill {
            -webkit-box-shadow: 0 0 0px 1000px white inset !important;
            -webkit-text-fill-color: #009688;
        }

    </style>
</head>
<body>

<div class="panel-lite">
    <div class="thumbur">
        <div class="icon-lock"></div>
    </div>
    <h4>BI demo</h4>
    <div class="form-group">
        <input id="un" required="required" class="form-control" style="z-index: 0"/>
        <label class="form-label">用户名 </label>
    </div>
    <div class="form-group">
        <input  id="pw" type="password" required="required" class="form-control" style="z-index: 0"/>
        <label class="form-label">密　码</label>
    </div>
    <a href="#">忘记密码 ? </a>
    <button class="floating-btn" onclick="clickLogin()"><i class="icon-arrow"></i></button>
    <form:form action="login" method="post" id="loginForm" style="display:none">
        <input id="username" name="username"/>
        <input id="password" name="password"/>
    </form:form>
    <script>
        function clickLogin(){
            var un = document.getElementById('un').getAttribute("value");
            var pw = document.getElementById('pw').getAttribute("value");
            document.getElementById('username').setAttribute(un);
            document.getElementById('password').setAttribute(pw);
            document.getElementById("loginForm").submit();
        }
    </script>
</div>
</body>
</html>