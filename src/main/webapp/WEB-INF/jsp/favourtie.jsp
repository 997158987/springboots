<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/8/31
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>收藏</title>
    <script>
        function deletefavourite(id) {
            location.href= "deletefavourite?bookInfoId="+id ;
        }

        function shop(id) {
            $(function () {
                $.ajax({
                    url:"shoptrollyreal",
                    type:"POST",
                    data:"trolley_book="+id,
                    dataType:"json",
                    success:function() {
                    }
                });
                return false;
            })
        }
        $(function () {
            $('[data-toggle="popover"]').popover()
            $('[data-toggle="shop"]').popover()
        })

        function allremark(id) {
            $.ajax({
                url:"selectRemark",
                type:"POST",
                data:"remark_bookId="+id,
                dataType:"json",
                success:function(data) {
                    if(data!=''){
                        $.each(data, function(i, item){
                            $(".modal-body").append('<div class="alert alert-info" role="alert">'+'<p>'+'用户名:'+item.user.username+'</p>'+item.remarkinfo+'</div>')
                        });
                    }
                    else {
                        $(".modal-body").append('<div class="alert alert-info" role="alert">'+'暂无评论'+'</div>')
                    }
                },
                error:function(data) {
                    alert('调用评论失败')
                }
            })
            $(".modal-body").html('')
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
            <a class="navbar-brand" href="main">主页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="allinfo">书籍信息 <span class="sr-only">(current)</span></a></li>
                <li><a href="shoptrolly">购物车</a></li>
                <li class="active"><a href="favourtie">收藏夹</a></li>
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


<table class="table table-bordered" style="width: 900px;margin-top: 50px" align="center">
    <tr>
        <th>书编号</th>
        <th>书名称</th>
        <th>书作者</th>
        <th>出版社</th>
        <th>书类别</th>
        <th>书价格</th>
        <th>书库存</th>
    </tr>
    <c:forEach items="${allfavourite}" var="allfavourite">
        <tr>
            <th>${allfavourite.book.book_id}</th>
            <th>${allfavourite.book.book_name}</th>
            <th>${allfavourite.book.writer}</th>
            <th>${allfavourite.book.publish}</th>
            <th>${allfavourite.book.cate.category_name}</th>
            <th>${allfavourite.book.price}</th>
            <th>${allfavourite.book.num}</th>
            <th><button type="button" class="btn btn-success" name="shop" onclick="shop(${allfavourite.book.book_id})" data-toggle="shop" data-trigger="focus" title="提示" data-content="已成功添加至购物车">添加至购物车</button></th>
            <th><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="allremark(${allfavourite.book.book_id})">查看评论</button></th>
            <th><button type="button" class="btn btn-danger" onclick="deletefavourite(${allfavourite.book.book_id}) ">删除</button></th>
        </tr>
    </c:forEach>
</table>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">评论信息</h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
