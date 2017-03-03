<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 001117020012
  Date: 2017/2/24
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页显示</title>

</head>
<body>
<table cellpadding="0" b="2" >
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>密码</td>
        <td>地址</td>
    </tr><%--${requestScope.user}--%>
   <c:forEach items="${res.data.listUser}" var="u">
        <tr>
            <td id="${u.id}"> ${u.id}</td>
            <td><a href="${pageContext.request.contextPath}">${u.name}</a></td>
            <td>${u.password}</td>
            <td>${u.address}</td>
        </tr>
    </c:forEach>
</table>
    共${res.data.totlePage}页
    当前第${res.data.pageNum}页</br>
    <a href="${pageContext.request.contextPath}/getPage/1">首页</a>
    <a href="${pageContext.request.contextPath}/getPage/${res.data.pageNum-1}">上一页
    </a> <a href="${pageContext.request.contextPath}/getPage/${res.data.pageNum+1}">下一页</a>
    <a href="${pageContext.request.contextPath}/getPage/${res.data.totlePage}">末页</a></br>
    <form action="${pageContext.request.contextPath}/getPage1" method="POST">
        转到第:<input type="text" name="pageNum" >页
    <input type="submit" value="确认"/>
   </form>
</body>
</html>