<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/9/3
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改个人信息</title>
    <script>
        $(function () {
            $('[data-toggle="info"]').popover()
        })
    </script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="main">主页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="allinfo">书籍信息 <span class="sr-only">(current)</span></a></li>
                <li><a href="shoptrolly">购物车</a></li>
                <li><a href="favourtie">收藏夹</a></li>
                <li><a href="order">查看订单</a></li>
            </ul>
            <form class="navbar-form navbar-left" action="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="输入要搜索书籍名称" name="book_name">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎您  ${username}</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">操作 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="changeinfo">修改个人信息</a></li>
                        <li><a href="receiveaddress">新增收货地址</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="out">退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<form action="changeInfoReal">
    <div align="center" style="margin-top: 100px">
        <div class="form-group">
            <label>输入需要修改的手机号</label>
            <input type="text" class="form-control" id="exampleInputPhone1" name="phone" placeholder="手机">
        </div>
        <div class="form-group">
            <label>输入需要修改的邮箱</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="email" placeholder="邮箱">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">性别</label>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="0" name="gender"> 男
            </label>
            <label>
                <input type="checkbox" value="1" name="gender"> 女
            </label>
        </div>
        <button type="submit" class="btn btn-default" data-toggle="info" data-trigger="focus" title="提示" data-content="修改信息成功">修改</button>
    </div>
</form>
</body>
</html>
