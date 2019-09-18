<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 2019/9/4
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>管理员登陆</title>
</head>
<body>
<form class="form-horizontal" action="/admin/selectAdmin">
    <div style="margin-top: 150px;margin-left: 500px">
        <c:if test="${error!=null}">
            <div class="alert alert-success" role="alert" style="width: 200px;margin-left: 160px;text-align: center">账号或密码不正确</div>
        </c:if>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label" >用户名</label>
            <div class="col-sm-10" >
                <input type="text" class="form-control" id="inputEmail3" placeholder="用户名" name="admin_name">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" name="admin_pwd" placeholder="密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> 记住密码
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-info">登录</button>
            </div>
        </div>

    </div>
</form>
</body>
</html>
