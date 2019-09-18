<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/9/4
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单管理</title>
    <script>
        function changeBookstate(id) {
            location.href= "changeBookstate?order_id="+id ;
        }
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
            <a class="navbar-brand" href="#">主页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li ><a href="allAdminBooks">管理书籍 <span class="sr-only">(current)</span></a></li>
                <li><a href="addBook">添加书籍</a></li>
                <li class="active"><a href="manageBook">管理订单</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎您  ${admin.getAdmin_name()}</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">操作 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="out">退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<table class="table table-bordered" style="width: 1000px;margin-top: 50px" align="center">
    <tr>
        <th>订单编号</th>
        <th>书籍名称</th>
        <th>书籍价格</th>
        <th>订单生成时间</th>
        <th>订单总价</th>
        <th>订单状态</th>
        <th>收货地址</th>
        <th>收货姓名</th>
        <th>手机号</th>
    </tr>
    <c:forEach items="${allOrder}" var="allOrder">
        <tr>
            <th>${allOrder.order.order_id}</th>
            <th>${allOrder.book.book_name}</th>
            <th>${allOrder.book.price}</th>
            <th>${allOrder.order.order_time}</th>
            <th>${allOrder.order.total}</th>
            <th>${allOrder.order.orderState1.state}</th>
            <th>${allOrder.address.address}</th>
            <th>${allOrder.address.reciver_name}</th>
            <th>${allOrder.address.reciver_phone}</th>
            <th><button type="button" class="btn btn-info" name="shop" onclick="changeBookstate(${allOrder.order.order_id})">发货</button></th>
        </tr>
    </c:forEach>
</table>

</body>
</html>
