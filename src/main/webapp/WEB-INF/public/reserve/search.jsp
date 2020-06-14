<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 3 | Projects</title>
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
    <!-- Google Font: Source Sans Pro -->

    <!-- SweetAlert2 -->
    <link rel="stylesheet" href="../../plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">
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

                        <h1>预定机票</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Projects</li>
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
                            style="vertical-align: inherit;">航班列表</font></font></h3>

                </div>
                <div class="card-body table-responsive p-0" style="height: 400px;">
                    <table class="table table-head-fixed text-nowrap">
                        <thead>
                        <tr>
                            <th style="width: 20%">出发地</th>
                            <th style="width: 20%">目的地</th>
                            <th style="width: 10%">价格</th>
                            <th style="width: 20%">出发时间</th>
                            <th style="width: 20%">到达时间</th>
                            <th style="width: 10%"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="data" items="${flights}">
                            <tr>
                                <td>${data.departure}</td>
                                <td>${data.destination}</td>
                                <td>${data.price}</td>
                                <td>${data.startTime}</td>
                                <td>${data.arrivalTime}</td>
                                <td class="text-right py-0 align-middle">
                                    <div class="btn-group btn-group-sm">

                                            <%--                                        onclick="reserve(${data.id},${data.departure},${data.destination},${data.price},${data.startTime},${data.arrivalTime})">--%>

                                        <button type="button" class="btn btn-block bg-gradient-primary"
                                                data-toggle="modal" data-target="#modal-default"
                                                onclick="reserve('${data.id}','${data.departure}','${data.destination}','${data.price}','${data.startTime}','${data.arrivalTime}')">
                                            预定
                                        </button>

                                            <%--                                        <a href="/flight?opt=update&id=${data.id}" class="btn btn-info"><i--%>
                                            <%--                                                class="fas fa-pencil-alt"></i></a>--%>

                                            <%--                                        <button type="button" class="btn btn-danger" data-toggle="modal"--%>
                                            <%--                                                data-target="#error-danger"><i--%>
                                            <%--                                                class="fas fa-trash" onclick="selectDel(${data.id})"></i></button>--%>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>


                </div>
                <a href="/reserve" class="btn btn-secondary float-right" style="width: 100px">返回</a>
                <!-- /.card-body -->
            </div>


            <div class="modal fade" id="modal-default">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">信息打印</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body" id="content">
                            <p id="p_content"></p>
                            <p id="p_name"></p>
                            <p id="p_card"></p>
                            <p id="p_phone"></p>
                            <p id="p_loc"></p>
                            <p id="p_timer"></p>
                            <p id="p_price"></p>
                        </div>
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary swalDefaultSuccess" onclick="submitFrom()">
                                确定并打印
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


    <%@include file="../menu/footer.jsp" %>

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
<!-- SweetAlert2 -->
<script src="../../plugins/sweetalert2/sweetalert2.min.js"></script>


<form action="/reserve" method="post" id="form">
    <input name="flightId" type="hidden" id="flightId">
    <input name="userId" type="hidden" id="userId">
</form>

<script>

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
                title: '订票成功，正在打印机票！'
            })
        });

    });

    function reserve(id, departure, destination, money, startTime, arrivalTime) {
        console.log("reserve");
        let content = document.getElementById("p_content");
        let name = document.getElementById("p_name");
        let card = document.getElementById("p_card");
        let phone = document.getElementById("p_phone");
        let loc = document.getElementById("p_loc");
        let timer = document.getElementById("p_timer");
        let price = document.getElementById("p_price");

        name.innerText = '姓名：${user.userName}';
        card.innerText = '身份证：${user.identityCard}';
        phone.innerText = '手机：${user.phone}';
        loc.innerText = '由 ' + departure + ' 飞往  ' + destination;
        timer.innerText = startTime + ' 到 ' + arrivalTime;
        price.innerText = ' 合计: ' + money;
        document.getElementById("flightId").value = id;
        document.getElementById("userId").value = "${user.identityCard}";
    }

    function submitFrom() {
        document.getElementById("form").submit();
    }

</script>
</body>
</html>
