<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/9/4
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>管理员主页面</title>
    <script>
        function changeBook(id) {
            location.href= "changeBook?bookInfoId="+id ;
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
                <li class="active"><a href="allAdminBooks">管理书籍 <span class="sr-only">(current)</span></a></li>
                <li><a href="addBook">添加书籍</a></li>
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


<table class="table table-bordered" style="width: 800px;margin-top: 50px" align="center">
    <tr>
        <th>书编号</th>
        <th>书名称</th>
        <th>书作者</th>
        <th>出版社</th>
        <th>书类别</th>
        <th>书价格</th>
        <th>书库存</th>
    </tr>
    <c:forEach items="${allbook}" var="book">
        <tr>
            <th>${book.book_id}</th>
            <th>${book.book_name}</th>
            <th>${book.writer}</th>
            <th>${book.publish}</th>
            <th>${book.cate.category_name}</th>
            <th>${book.price}</th>
            <th>${book.num}</th>
            <th><button type="button" class="btn btn-info" name="shop" onclick="changeBook(${book.book_id})">修改信息</button></th>
        </tr>
    </c:forEach>
</table>

<nav aria-label="Page navigation" align="center">
    <ul class="pagination">
        <li>
            <a href="allAdminBooks?PageNos=${ThisPageNum-1}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li><a href="allAdminBooks?PageNos=1">1</a></li>
        <li><a href="allAdminBooks?PageNos=2">2</a></li>
        <li><a href="allAdminBooks?PageNos=3">3</a></li>
        <li><a href="allAdminBooks?PageNos=4">4</a></li>
        <li><a href="allAdminBooks?PageNos=5">5</a></li>
        <li>
            <a href="allAdminBooks?PageNos=${ThisPageNum+1}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</body>
</html>
