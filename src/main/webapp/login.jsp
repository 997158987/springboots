<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/8/31
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>登录</title>
</head>
<body>
<form class="form-horizontal" action="/user/selectuser">
    <div style="margin-top: 150px;margin-left: 500px">
        <c:if test="${error!=null}">
        <div class="alert alert-success" role="alert" style="width: 200px;margin-left: 175px;text-align: center">${error}</div>
        </c:if>
    <div class="form-group">
        <label for="user" class="col-sm-2 control-label" >用户名</label>
        <div class="col-sm-10" >
            <input type="text" class="form-control" id="user" placeholder="用户名" name="username" style="width: 200px">
        </div>
    </div>
    <div class="form-group">
        <label for="pwd" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="pwd" name="password" placeholder="密码" style="width: 200px">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox" id="remember"> 记住密码
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-info" style="width: 200px" onclick="fn()">登录</button>
        </div>
    </div>
    </div>
</form>


<script type="text/javascript">
    var user = document.getElementById('user'),
        pass = document.getElementById('pwd'),
        check = document.getElementById('remember'),
        localUser = localStorage.getItem('user') || ''; //获取到user的值并保存
    localPass = localStorage.getItem('pass') || ''; //获取到pwd的值并保存
    user.value = localUser;
    pass.value = localPass;
    if (localUser !== '' && localPass !== '') {
        check.setAttribute('checked', '');
    }

    function fn() {
        if (check.checked) {
            localStorage.setItem('user', user.value);
            localStorage.setItem('pass', pass.value);
        } else {
            localStorage.setItem('user', '');
            localStorage.setItem('pass', '');
        }
    }
</script>
</body>
</html>
