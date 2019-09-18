<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/8/30
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="user/regist">
    <div align="center" style="margin-top: 100px">
    <div class="form-group">
        <label for="exampleInputEmail1">用户名</label>
        <input type="text" class="form-control" id="exampleInputUsername1" name="username" placeholder="用户名">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="密码">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">手机</label>
        <input type="text" class="form-control" id="exampleInputPhone1" name="phone" placeholder="手机">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">邮箱</label>
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
        <button type="submit" class="btn btn-primary" style="width: 300px">点击注册</button><br><br>
        <button type="button" class="btn btn-default" style="width: 300px" onclick="location.href='login.jsp'">已有账号？</button>
    </div>
</form>
</body>
</html>
