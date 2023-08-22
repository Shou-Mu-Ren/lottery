<%--
  Created by IntelliJ IDEA.
  User: 盛康宁
  Date: 2023/8/22
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>开奖</title>
</head>
<body>
<div id="head" style="width:800px; margin:auto; text-align:center">
    <h3>id：${win.id}
        <c:if test="${win.roll==0}">
            开奖状态：未开奖
            号码：?
        </c:if>
        金额/每注：${win.money}
    </h3>
    <form action="${ctx}/lottery/admin/roll" method="post">
        <input type="hidden" name="winId" value="${win.id}">
        <input type="submit" value="开奖" /><br>
    </form>
    <form action="${ctx}/lottery/admin/list" method="post">
        <input type="submit" value="去开奖列表" /><br>
    </form>
</div>
</body>
</html>
