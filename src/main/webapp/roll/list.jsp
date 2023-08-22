<%--
  Created by IntelliJ IDEA.
  User: 盛康宁
  Date: 2023/8/22
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>开奖列表</title>
</head>
<body>
<div id="head" style="width:400px; margin:auto; text-align:center">
    <form action="${ctx}/lottery/admin/rollPage" method="post">
        <input type="submit" value="去开奖" /><br>
    </form>
</div>
<div id="box" style="width:800px; margin:auto; text-align:center">
    <c:if test="${not empty wins}">
        <table style="border:1px solid black; width:100%; text-align:center">
            <thead>
            <tr style="border:1px solid black">
                <th style="border:1px solid black">id</th>
                <th style="border:1px solid black">开奖状态</th>
                <th style="border:1px solid black">号码</th>
                <th style="border:1px solid black">金额/每注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${wins}" var="win">
                <tr style="border:1px solid black">
                    <td style="border:1px solid black">${win.id}</td>
                    <c:if test="${win.roll==0}">
                        <td style="border:1px solid black">未开奖</td>
                        <td style="border:1px solid black">?</td>
                    </c:if>
                    <c:if test="${win.roll==1}">
                        <td style="border:1px solid black">已开奖</td>
                        <td style="border:1px solid black">${win.number}</td>
                    </c:if>
                    <td style="border:1px solid black">${win.money}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

</body>
</html>

