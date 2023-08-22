<%--
  Created by IntelliJ IDEA.
  User: 盛康宁
  Date: 2023/8/22
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>彩票购买</title>
</head>
<body>
<div id="head" style="width:600px; margin:auto; text-align:center">
    <form action="${ctx}/lottery/user/buy" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <h3>用户：${user.username} 余额：${user.money}</h3>
        <input type="hidden" name="winId" value="${win.id}">
        <h3>id：${win.id}
            <c:if test="${win.roll==0}">
                开奖状态：未开奖
                号码：?
            </c:if>
            <c:if test="${win.roll==1}">
                开奖状态：已开奖
                号码：${win.number}
            </c:if>
            金额/每注：${win.money}
        </h3>
        选择号码<br/>
        <input type="radio" name="number" value="1"> 1
        <input type="radio" name="number" value="2"> 2
        <input type="radio" name="number" value="3"> 3
        <input type="radio" name="number" value="4"> 4
        <input type="radio" name="number" value="5"> 5
        <br/><br/>
        输入倍数(0~100)<br/>
        <input type="text" name="multiple" > <br/><br/>
        <input type="reset" value="复位">
        <input type="submit" value="购买彩票" /><br>
    </form>
    <form action="${ctx}/lottery/user/list" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <input type="submit" value="去彩票列表" /><br>
    </form>
</div>
</body>
</html>
