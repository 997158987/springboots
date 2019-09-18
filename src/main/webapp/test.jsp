<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/9/1
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<html>
<head>
    <title>激活邮箱</title>
</head>

<body>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title></title>
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
</head>

<body>

账号:<input type="text" id="user"> 密码:
<input type="password" id="pwd"> 记住密码:
<input type="checkbox" id="remember">
<button onclick="fn()">登录</button>


</body>
</html>
