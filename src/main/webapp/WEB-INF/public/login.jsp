<%--
  Created by IntelliJ IDEA.
  User: 12579
  Date: 2020/5/18
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Aviation | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="../plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <b>机票预定系统</b>登录</a>
    </div>
    <!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg">
                <c:if test="${msg!=null}">
                    ${msg}
                </c:if>
                <c:if test="${msg==null}">
                    Welcome to AirTicket Booking System
                </c:if>
            </p>

            <form action="/login" method="post">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="身份证" name="user" value="${u}" }>
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" placeholder="密码" name="psw">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="验证码" name="captcha">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span></span>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <img class="form-control" src="/captcha" onclick="change()" id="captcha"/>
                    </div>
                    <!-- /.col -->
                </div>

                <div class="social-auth-links text-center mb-3">

                    <button type="submit" class="btn btn-primary btn-block">登 录</button>

                </div>
            </form>
            <a href="./register" class="btn btn-block btn-danger">
                <%--                <i class="fab fa-google-plus mr-2"></i>注册--%>
                <i></i>注 册
            </a>


        </div>
        <!-- /.login-card-body -->
    </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>

<script>
    function change(){
        document.getElementById("captcha").src="captcha?"+Math.random();
    }
</script>

</body>
</html>
