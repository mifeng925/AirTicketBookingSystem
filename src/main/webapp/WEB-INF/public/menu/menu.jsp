    <%@ page import="com.bee.airsystem.entity.UserBase" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="main" class="brand-link">
        <img src="../../image/icon.png" alt="Air" class="brand-image img-circle elevation-3"
        style="opacity: .8">
        <span class="brand-text font-weight-light">机票预订系统</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
        <img src="../../image/head.png" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
        <a href="#" class="d-block">${user.userName }</a>
        </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        <!-- Add icons to the links using the .nav-icon class
        with font-awesome or any other icon font library -->
        <li class="nav-item has-treeview menu-open">
        <a href="#" class="nav-link active">
        <i class="nav-icon fas fa-tachometer-alt"></i>
        <p>
        基础信息
        <i class="right fas fa-angle-left"></i>
        </p>
        </a>
        <ul class="nav nav-treeview">
        <li class="nav-item">
        <a href="./band" class="nav-link${(requestScope.path eq "/admin/band")?" active":""}">
        <i class="far fa-circle nav-icon"></i>
        <p>班级管理</p>
        </a>
        </li>
        <li class="nav-item">
        <a href="./student" class="nav-link${(requestScope.path eq "/admin/student")?" active":""}">
        <i class="far fa-circle nav-icon"></i>
        <p>学生信息管理</p>
        </a>
        </li>
        </ul>
        </li>
        <li class="nav-item has-treeview menu-open">
        <a href="#" class="nav-link active">
        <i class="nav-icon fas fa-tachometer-alt"></i>
        <p>
        超级管理
        <i class="right fas fa-angle-left"></i>
        </p>
        </a>
        <ul class="nav nav-treeview">
        <li class="nav-item">
        <a href="./planes" class="nav-link${(requestScope.path eq "/admin/user")?" active":""}">
        <i class="far fa-circle nav-icon"></i>
        <p>飞机管理</p>
        </a>
        </li>
        <li class="nav-item">
        <a href="./student" class="nav-link${(requestScope.path eq "/admin/perm")?" active":""}">
        <i class="far fa-circle nav-icon"></i>
        <p>权限管理</p>
        </a>
        </li>
        </ul>
        </li>
        <li class="nav-item">
        <a href="#" class="nav-link">
        <i class="nav-icon fas fa-th"></i>
        <p>
        Simple Link
        <span class="right badge badge-danger">New</span>
        </p>
        </a>
        </li>
        </ul>
        </nav>
        <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
        </aside>
