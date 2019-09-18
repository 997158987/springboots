<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/9/2
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单信息</title>
    <script>
        function confirmAddress(id){
            location.href= "changeState?order_id="+id ;
        }

        function Comments(id) {
            location.href= "UserComment?remark_bookId="+id ;
        }

        function Everyorder(id) {
            $.ajax({
                url:"selectOrderById",
                type:"POST",
                data:"order_id="+id,
                dataType:"json",
                success:function(data) {
                    console.log(data.orderinfo)
                    $.each(data.orderinfo, function(i, item){
                        $(".modal-body").append('<div class="alert alert-info" role="alert">'+'<p>'+'书名:'+item.book.book_name+'</p>'
                            +'<p>'+'类别:'+item.book.cate.category_name+'</p>'
                            +'<p>'+'作者:'+item.book.writer+'</p>'
                            +'<p>'+'出版社:'+item.book.publish+'</p>'+'</div>')
                    });
                    $(".modal-body").append('<div class="alert alert-info" role="alert">'+'收货地址:'+'<br>'+data.orderinfo[0].address.address+'<br>'
                        +data.orderinfo[0].address.reciver_name+'<br>'
                        +data.orderinfo[0].address.reciver_phone+'</div>')
                    // else {
                    //     $(".modal-body").append('<div class="alert alert-info" role="alert">'+'暂无评论'+'</div>')
                    // }
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
                <li ><a href="allinfo">书籍信息 </a></li>
                <li><a href="shoptrolly">购物车</a></li>
                <li><a href="favourtie">收藏夹</a></li>
                <li class="active"><a href="order">查看订单</a></li>
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
        <th>订单编号</th>
        <th>书籍名称</th>
        <th>书籍价格</th>
        <th>订单生成时间</th>
        <th>订单总价</th>
        <th>订单状态</th>
    </tr>
    <c:forEach items="${allorder}" var="allorder" varStatus="j">
        <tr>
            <th>${allorder.orderinfo[0].orderId}</th>
            <th>${orderinfo.book.book_name}</th>
            <th>${orderinfo.book.price}</th>
            <th>${allorder.order_time}</th>
            <th>${allorder.total}</th>
            <th>${allorder.orderState1.state}</th>
            <th><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="Everyorder(${allorder.orderinfo[0].orderId})">订单详情</button></th>
            <th><button type="button" class="btn btn-primary" onclick="confirmAddress(${allorder.orderinfo[0].orderId})">确认收货</button></th>
        </tr>
        <c:forEach items="${allorder.orderinfo}" var="orderinfo" varStatus="i">
        <tr>
            <th></th>
            <th>${orderinfo.book.book_name}</th>
            <th>${orderinfo.book.price}</th>
            <th></th>
            <th></th>
            <th></th>
            <th><button type="button" class="btn btn-warning" <c:if test="${allorder.orderState1.state eq '已完成'==false}">disabled="disabled" </c:if>) onclick="Comments(${orderinfo.book.book_id})">评论</button></th>
        </tr>
        </c:forEach>
    </c:forEach>
</table>


<%--查看评论--%>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">订单详情</h4>
            </div>
            <div class="modal-body">
                <div class="alert alert-info" role="alert">...</div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
