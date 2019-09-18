<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/9/1
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>购物车</title>
    <script>
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
                <li ><a href="allinfo">书籍信息 </a></li>
                <li class="active"><a href="shoptrolly">购物车</a></li>
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

<form action="/user/insertorder">
<table class="table table-bordered" style="width: 550px;margin-top: 50px" align="center" id="tab">
    <tr>
        <th>勾选</th>
        <th>书名称</th>
        <th>书类别</th>
        <th>书价格</th>
        <th>书库存</th>
    </tr>
    <c:forEach items="${allshop}" var="allshop" varStatus="i">
        <tr>
            <th>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="${allshop.book.book_id}" name="shopchoice"  onclick="selectepart(${i.index})">
                    </label>
                    <label>
                        <input type="checkbox" name="price" value="${allshop.book.price}"  id="clikme${i.index}" style="display:none">
                    </label>
                    <label>
                        <input type="checkbox" name="admin_id" value="${allshop.book.admin_book}"  id="admin${i.index}" style="display:none">
                    </label><br>
                </div>
            </th>
            <th>${allshop.book.book_name}</th>
            <th>${allshop.book.cate.category_name}</th>
            <th>${allshop.book.price}</th>
            <th>${allshop.book.num}</th>
            <th><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="allremark(${allshop.book.book_id})">查看评论</button></th>
            <th><button type="button" class="btn btn-danger"  onclick=" deleteshop(${allshop.book.book_id})">删除</button></th>
        </tr>
    </c:forEach>
</table>
    <h5 style="margin-left: 495px;margin-top: 20px;width: 100px" id="address"><strong>收货地址:</strong></h5>
<table class="table table-bordered" style="width: 550px;margin-top: 20px" align="center">
    <tr>
        <th>勾选</th>
        <th>收件人</th>
        <th>手机号</th>
        <th>地址</th>
        <th>姓名</th>
    </tr>
    <c:forEach items="${alladdress}" var="alladdress">
        <tr>
            <th>
                <div class="radio">
                    <label>
                        <input type="radio" name="addresschoice"  value="${alladdress.address_id}" checked>
                    </label>
                </div>
            </th>
            <th>${alladdress.reciver}</th>
            <th>${alladdress.reciver_phone}</th>
            <th>${alladdress.address}</th>
            <th>${alladdress.reciver_name}</th>
            <th><button type="button" class="btn btn-info" onclick="changeAddress(${alladdress.address_id})">修改</button></th>
            <th><button type="button" class="btn btn-danger"  onclick=" deleteAddress(${alladdress.address_id})">删除</button></th>
        </tr>
    </c:forEach>
</table>
<button type="submit" class="btn btn-primary" style="margin-left: 990px;margin-top: 20px" id="buy">购买</button>
</form>
<script type="text/javascript">
    function deleteshop(id) {
        location.href= "deleteshop?trolley_book="+id ;
    }

    function  changeAddress(id) {
        location.href= "changeAddress?address_id="+id ;
    }

    function deleteAddress(id) {
        location.href= "deleteAddress?address_id="+id ;
    }

    function selectepart(id) {
        var name="#clikme"+id
        var name1="#admin"+id
        var state=$(name).prop('checked')
        if (state==true){
            $(name).prop("checked",false)
            $(name1).prop("checked",false)
        }
        else {
            $(name).prop("checked","checked")
            $(name1).prop("checked","checked")
        }
    }
</script>
</body>


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
</html>
