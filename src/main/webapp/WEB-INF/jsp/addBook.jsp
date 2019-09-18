<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/9/4
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>增加书籍</title>
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
                <li><a href="allAdminBooks">管理书籍 <span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="addBook">添加书籍</a></li>
                <li><a href="manageBook">管理订单</a></li>
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

<form action="addBookReal">
    <div align="center" style="margin-top: 50px">
        <div class="form-group">
            <label>书名</label>
            <input type="text" class="form-control" name="book_name" placeholder="书名" >
        </div>
        <div class="form-group">
            <label>作者</label>
            <input type="text" class="form-control" name="writer" placeholder="作者名" >
        </div>
        <div class="form-group">
            <label>类别</label>
            <select class="form-control" name="category">
                <c:forEach items="${allcategory}" var="allcategory">
                    <option value="${allcategory.category_id}" <c:if test="${bookinfo.category eq allcategory.category_id}">selected="selected"</c:if>>${allcategory.category_name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>价格</label>
            <input type="text" class="form-control" name="price" placeholder="价格" >
        </div>
        <div class="form-group">
            <label>库存数量</label>
            <input type="text" class="form-control" name="num" placeholder="库存数量" >
        </div>
        <div class="form-group">
            <label>出版社</label>
            <input type="text" class="form-control" name="publish" placeholder="出版社" >
        </div>
        <button type="submit" class="btn btn-default" data-toggle="info" data-trigger="focus" title="提示" data-content="修改信息成功">添加</button>
    </div>
</form>
</body>
</html>
