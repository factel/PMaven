<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/6/25
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>jsp</title>
</head>
<body>


<table border="1" cellspacing="0" cellpadding="0" width="80%">
    <tr>
        <td>id</td>
        <td>sal</td>
        <td>breed</td>
        <td>操作</td>
    </tr>

<c:forEach var="li" items="${dogs}">
    <tr>
        <td>${li.id}</td>
        <td> ${li.sal}</td>
        <td> ${li.breed}</td>
        <td>
        <a href="${pageContext.request.contextPath}/deleteDog?id=${li.id}&breed=${li.breed}">删除</a>
        <a href="${pageContext.request.contextPath}/findDogById.do?id=${li.id}&sal=${li.sal}&breed=${li.breed}">修改</a>
        <a href="${pageContext.request.contextPath}/queryDogAll.do">查询所有</a>
        <a href="${pageContext.request.contextPath}/addOrUpdateDog.jsp">增加一狗</a>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
