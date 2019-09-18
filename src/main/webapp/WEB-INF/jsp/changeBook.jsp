<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/9/4
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改书籍信息</title>
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
                <li class="active"><a href="allAdminBooks">管理书籍 <span class="sr-only">(current)</span></a></li>
                <li><a href="addBook">添加书籍</a></li>
                <li><a href="manageBook">管理订单</a></li>
            </ul>
            <form class="navbar-form navbar-left" action="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="输入要搜索书籍名称" name="book_name">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
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

<form action="changeBookReal">
    <div align="center" style="margin-top: 50px">
        <div class="form-group">
            <label>输入需要修改的书名</label>
            <input type="text" class="form-control" name="book_name" value="${bookinfo.book_name}">
        </div>
        <div class="form-group">
            <label>输入需要修改的作者</label>
            <input type="text" class="form-control" name="writer" value="${bookinfo.writer}">
        </div>
        <div class="form-group">
            <label>输入需要修改的类别</label>
            <select class="form-control" name="category">
                    <c:forEach items="${allcategory}" var="allcategory">
                        <option value="${allcategory.category_id}" <c:if test="${bookinfo.category eq allcategory.category_id}">selected="selected"</c:if>>${allcategory.category_name}</option>
                    </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>输入需要修改的价格</label>
            <input type="text" class="form-control" name="price" value="${bookinfo.price}">
        </div>
        <div class="form-group">
            <label>输入需要修改的库存数量</label>
            <input type="text" class="form-control" name="num" value="${bookinfo.num}">
        </div>
        <div class="form-group">
            <label>输入需要修改的出版社</label>
            <input type="text" class="form-control" name="publish" value="${bookinfo.publish}">
        </div>
        <input type="hidden" value="${bookinfo.book_id}" name="book_id">
        <button type="submit" class="btn btn-default" data-toggle="info" data-trigger="focus" title="提示" data-content="修改信息成功">修改</button>
    </div>
</form>
</body>
</html>
