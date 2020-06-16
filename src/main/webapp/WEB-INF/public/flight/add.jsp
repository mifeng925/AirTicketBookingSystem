<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AirBee</title>
    <link rel="icon" sizes="any" mask href="../../image/icon.png">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <!-- Navbar -->
    <%@include file="../menu/navbar.jsp" %>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <%@include file="../menu/menu.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>航班管理系统</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/main">首页</a></li>
                            <li class="breadcrumb-item"><a href="/flight">航班管理</a></li>
                            <li class="breadcrumb-item active">增加/修改</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <form action="/flight" method="post">
                <input name="id" type="hidden" value="${id}">

                <div class="col-md">
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">添加航班</h3>
                        </div>
                        <div class="card-body">

                            <div class="form-group">
                                <label for="planeInput">飞机型号</label>
                                <select class="form-control custom-select" id="planeInput" name="plane">
                                    <c:forEach items="${planes}" var="plane">
                                        <option value="${plane.planeId}">${plane.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="departure">出发地</label>
                                <input type="text" id="departure" class="form-control" name="departure"
                                       value="${departure}">
                            </div>
                            <div class="form-group">
                                <label for="destination">目的地</label>
                                <input type="text" id="destination" class="form-control" name="destination"
                                       value="${destination}">
                            </div>
                            <div class="form-group">
                                <label for="price">价格</label>
                                <input type="text" id="price" class="form-control" name="price" value="${price}">
                            </div>

                            <div class="form-group">
                                <label for="flag">航班状态</label>
                                <select class="form-control custom-select" id="flag" name="flag">
                                    <option value="0">正常</option>
                                    <option value="1">停机</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="startTime">出发时间</label>
                                <div class="input-group" id="startTime">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                                    </div>
                                    <input type="text" class="form-control" data-inputmask-alias="datetime"
                                           name="startTime" value="${startTime}"
                                           data-inputmask-inputformat="yyyy-mm-dd HH:MM:ss" data-mask=""
                                           im-insert="false">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="endTime">到达时间</label>
                                <div class="input-group" id="endTime">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                                    </div>
                                    <input type="text" class="form-control" data-inputmask-alias="datetime"
                                           name="endTime" value="${endTime}"
                                           data-inputmask-inputformat="yyyy-mm-dd HH:MM:ss" data-mask=""
                                           im-insert="false">
                                </div>
                            </div>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
                <div class="row">
                    <div class="col-2">
                        <input type="submit" value="提交" class="btn btn-success ">
                        <a href="/flight" class="btn btn-secondary float-right">取消</a>
                    </div>
                </div>
            </form>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <%@include file="../menu/footer.jsp" %>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<!-- date-range-picker -->
<script src="../../plugins/daterangepicker/daterangepicker.js"></script>
<!-- jQuery -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<!-- Select2 -->
<script src="../../plugins/select2/js/select2.full.min.js"></script>

<script src="../../plugins/inputmask/min/jquery.inputmask.bundle.min.js"></script>

<script>
    <%--自动选择select--%>
    document.getElementById("planeInput").value = "${plane}";
    document.getElementById("flag").value = "${flag}";

    $(function () {
        //Money Euro
        $('[data-mask]').inputmask()
    })
</script>
</body>
</html>
