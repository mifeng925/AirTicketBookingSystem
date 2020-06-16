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
        <a href="" class="nav-link active">
        <i class="nav-icon fas fa-border-all"></i>
        <p>
        机票管理
        <i class="right fas fa-angle-left"></i>
        </p>
        </a>
        <ul class="nav nav-treeview">
        <li class="nav-item">
        <a href="/reserve" class="nav-link${(requestScope.path eq "/reserve")?" active":""}">
        <i class="far fa-circle nav-icon"></i>
        <p>预定机票</p>
        </a>
        </li>
        <li class="nav-item">
        <a href="/ticket" class="nav-link${(requestScope.path eq "/ticket")?" active":""}">
        <i class="far fa-circle nav-icon"></i>
        <p>我的机票</p>
        </a>
        </li>
        </ul>
        </li>
        <c:if test="${user.power>3}">
            <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
            <i class="nav-icon fas fa-address-card"></i>
            <p>
            管理员系统
            <i class="right fas fa-angle-left"></i>
            </p>
            </a>
            <ul class="nav nav-treeview">
            <li class="nav-item">
            <a href="./planes" class="nav-link${(requestScope.path eq "/planes")?" active":""}">
            <i class="far fa-circle nav-icon"></i>
            <p>飞机管理</p>
            </a>
            </li>
            <li class="nav-item">
            <a href="./flight" class="nav-link${(requestScope.path eq "/flight")?" active":""}">
            <i class="far fa-circle nav-icon"></i>
            <p>航班管理</p>
            </a>
            </li>
            </ul>
            </li>
        </c:if>

        </ul>
        </nav>
        <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
        </aside>
