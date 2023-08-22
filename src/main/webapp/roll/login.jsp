<%--
  Created by IntelliJ IDEA.
  User: 盛康宁
  Date: 2023/8/22
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>开奖登录</title>
</head>
<body>
<form action="${ctx}/lottery/admin/login" method="post">
    <div id="box" style="height:300px; width:400px; margin:auto; text-align:center">
        <h1>用户登录</h1>
        用户名：<input type="text"  name="username"/><br><br>
        密码：<input type="password"  name="password"/><br><br>

        <input type="submit" value="登录"/>
        <h6>${info}</h6>
    </div>
</form>
</body>
</html>