<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Aviation | Registration Page</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="../../plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition register-page">
<div class="register">
    <div class="register-logo">
        <b>机票预定系统</b>注册</a>
    </div>

    <div class="card">
        <div class="row">
            <!-- left column -->
            <div class="col-md-12">
                <div class="card-body register-card-body ">
                    <p class="login-box-msg">Register a new membership</p>

                    <form action="register" method="post" id="quickForm">

                        <div class=" form-group mb-3">
                            <input type="text" class="form-control" placeholder="姓名" name="userName">
                        </div>

                        <div class="form-group mb-3">
                            <input type="text" class="form-control" placeholder="昵称" name="nickName">
                        </div>

                        <div class="form-group mb-3">
                            <input type="number" class="form-control" placeholder="身份证号" name="id">
                        </div>

                        <div class="form-group mb-3">
                            <input type="text" class="form-control" placeholder="工作单位" name="work">
                        </div>

                        <div class="form-group mb-3">
                            <input type="email" class="form-control" placeholder="邮箱" name="email">
                        </div>

                        <div class="form-group form-group mb-3">
                            <input type="number" class="form-control" placeholder="电话" name="phone">
                        </div>


                        <div class="form-group mb-3">
                            <input type="password" class="form-control" placeholder="密码" name="pdw1">
                        </div>

                        <div class="form-group mb-3">
                            <input type="password" class="form-control" placeholder="重新输入密码" name="pdw2">
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
                                <img class="form-control" src="/captcha">
                            </div>
                            <!-- /.col -->
                        </div>
                        <div class="row">
                            <div class="col-8">
                                <div class="icheck-primary form-group">
                                    <input type="checkbox" id="agreeTerms" name="terms" value="agree">
                                    <label for="agreeTerms">
                                        我同意 <a href="#">条款</a>
                                    </label>
                                </div>
                            </div>
                            <!-- /.col -->
                            <div class="col-4">
                                <button type="submit" class="btn btn-primary btn-block">注 册</button>
                            </div>
                            <!-- /.col -->
                        </div>
                    </form>

                    <a href="./login" class="text-center">我已经有账号</a>
                </div>
            </div>
        </div>
        <!-- /.form-box -->
    </div><!-- /.card -->
</div>
<!-- /.register-box -->

<!-- jQuery -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>


<!-- jquery-validation -->
<script src="../../plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="../../plugins/jquery-validation/additional-methods.min.js"></script>


<script type="text/javascript">
    $(document).ready(function () {

        // function submit(){
        //     // document.getElementById("quickForm").onsubmit
        //     alert("Form successful submitted!");
        // }
        // $.validator.setDefaults({
        //     submitHandler: function () {
        //         alert("Form successful submitted!");
        //         document.getElementById("quickForm").onsubmit
        //     }
        // });
        $('#quickForm').validate({
            rules: {
                userName: {
                    required: true
                },
                nickName: {
                    required: true
                },
                id: {
                    minlength: 18,
                    required: true
                },
                work: {
                    required: true
                },
                email: {
                    required: true,
                    email: true,
                },
                phone: {
                    minlength: 11,
                    required: true
                },
                pdw1: {
                    required: true,
                },
                pdw2: {
                    required: true
                },
                captcha: {
                    required: true
                },
                terms: {
                    required: true
                },
            },
            messages: {
                userName: {
                    required: "这个是必填项"
                },
                nickName: {
                    required: "这个是必填项"
                },
                id: {
                    minlength: "请填写正确的身份证号",
                    required: "这个是必填项"
                },
                work: {
                    required: "这个是必填项"
                },
                email: {
                    required: "这个是必填项",
                    email: "请填写正确的邮箱",
                },
                phone: {
                    minlength: "请填写正确的手机号码",
                    required: "这个是必填项"
                },
                pdw1: {
                    required: "这个是必填项",
                },
                pdw2: {
                    required: "这个是必填项"
                },
                captcha: {
                    required: "请填写验证码"
                },
                terms: "请接受我们的条款"
            },
            errorElement: 'span',
            errorPlacement: function (error, element) {
                error.addClass('invalid-feedback');
                element.closest('.form-group').append(error);
            },
            highlight: function (element, errorClass, validClass) {
                $(element).addClass('is-invalid');
            },
            unhighlight: function (element, errorClass, validClass) {
                $(element).removeClass('is-invalid');
            }
        });
    });
</script>
</body>
</html>
