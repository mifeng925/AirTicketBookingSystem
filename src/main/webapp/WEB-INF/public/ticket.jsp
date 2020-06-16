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

    <!-- SweetAlert2 -->
    <link rel="stylesheet" href="../../plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">

</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <!-- Navbar -->
    <%@include file="menu/navbar.jsp" %>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <%@include file="menu/menu.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>我的机票</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/main">首页</a></li>
                            <li class="breadcrumb-item active">我的机票</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="card">

                <div class="card-header" style="align-content: center">
                    <h3 class="card-title"><font style="vertical-align: inherit;"><font
                            style="vertical-align: inherit;">机票列表</font></font></h3>
                </div>
                <div class="card-body table-responsive p-0" style="height: 430px;">
                    <table class="table table-head-fixed text-nowrap">
                        <thead>
                        <tr>
                            <th style="width: 10%">姓名</th>
                            <th style="width: 10%">飞机型号</th>
                            <th style="width: 10%">出发地</th>
                            <th style="width: 10%">目的地</th>
                            <th style="width: 5%">价格</th>
                            <th style="width: 10%">出发时间</th>
                            <th style="width: 10%">到达时间</th>
                            <th style="width: 5%" class="text-center">飞机状态</th>
                            <th style="width: 5%" class="text-center">用户状态</th>
                            <th style="width: 10%"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="data" items="${ticket}">
                            <tr>
                                <td>${data.userName}</td>
                                <td>${data.planeName}</td>
                                <td>${data.departure}</td>
                                <td>${data.destination}</td>
                                <td>${data.price}</td>
                                <td>${data.startTime}</td>
                                <td>${data.arrivalTime}</td>

                                <c:if test="${data.flightFlag==0}">
                                    <td class="project-state"><span class="badge badge-success">正常</span></td>
                                </c:if>
                                <c:if test="${data.flightFlag==1}">
                                    <td class="project-state"><span class="badge bg-danger">停机</span></td>
                                </c:if>

                                <c:if test="${data.userStatus==0}">
                                    <td class="project-state"><span class="badge btn-info">等候</span></td>
                                </c:if>
                                <c:if test="${data.userStatus==1}">
                                    <td class="project-state"><span class="badge badge-success">登机</span></td>
                                </c:if>
                                <c:if test="${data.userStatus==2}">
                                    <td class="project-state"><span class="badge bg-danger">延误</span></td>
                                </c:if>


                                    <%--                                <td class="text-right py-0 align-middle">--%>
                                    <%--                                    <div class="btn-group btn-group-sm">--%>

                                    <%--                                        <a href="#" class="btn btn-info"><i--%>
                                    <%--                                                class="fas fa-pencil-alt"></i></a>--%>

                                    <%--                                        <button type="button" class="btn btn-danger" data-toggle="modal"--%>
                                    <%--                                            data-target="#error-danger"><i--%>
                                    <%--                                                class="fas fa-trash" onclick="selectDel()"></i></button>--%>
                                    <%--                                    </div>--%>
                                    <%--                                </td>--%>

                                <td>
                                    <div class="btn-group btn-group-toggle">
                                        <c:if test="${data.userStatus==0 && data.flightFlag==0}">
                                            <button type="button" class="btn btn-success swalDefaultSuccess"
                                                    onclick="boarding(${data.reserveId})">登机
                                            </button>
                                        </c:if>
                                        <c:if test="${data.userStatus!=1 }">
                                            <button type="button" class="btn bg-danger " data-toggle="modal"
                                                    data-target="#error-danger" onclick="selectDel(${data.reserveId})">
                                                退票
                                            </button>
                                        </c:if>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.card-body -->
            </div>
            <!-- /.card -->

            <div class="modal fade" id="error-danger">
                <div class="modal-dialog">
                    <div class="modal-content bg-danger">
                        <div class="modal-header">
                            <h4 class="modal-title">警告</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p>确定要退订该班机票吗？</p>
                        </div>
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-outline-light" data-dismiss="modal">点错了</button>
                            <button type="button" class="btn btn-outline-light swalDefaultError" onclick="del()">我确定删除
                            </button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


    <%@include file="menu/footer.jsp" %>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

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

<script src="../../plugins/moment/moment.min.js"></script>
<script src="../../plugins/inputmask/min/jquery.inputmask.bundle.min.js"></script>
<!-- date-range-picker -->
<script src="../../plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap color picker -->

<!-- SweetAlert2 -->
<script src="../../plugins/sweetalert2/sweetalert2.min.js"></script>

<form method="post" action="/ticket" id="hiddenForm">
    <input type="hidden" name="opt" id="opt">
    <input type="hidden" name="_id" id="_id">
</form>
<script>
    $(function () {
        //Date range picker
        $('#reservation').daterangepicker();

    })

    $(function () {
        const Toast = Swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3000
        });

        $('.swalDefaultSuccess').click(function () {
            Toast.fire({
                icon: 'success',
                title: ' 登机成功，祝你旅途愉快！'
            })
        });

        $('.swalDefaultError').click(function () {
            Toast.fire({
                icon: 'error',
                title: ' 机票退订成功，欢迎下次乘坐！'
            })
        });

    });

    function del() {
        document.getElementById("hiddenForm").submit();
    }

    function selectDel(id) {
        document.getElementById("opt").value = "del";
        document.getElementById("_id").value = id;
    }

    function boarding(id) {
        document.getElementById("opt").value = "boarding";
        document.getElementById("_id").value = id;
        document.getElementById("hiddenForm").submit();
    }

</script>
</body>
</html>
