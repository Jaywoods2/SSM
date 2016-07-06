<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top</title>
<style type="text/css">
.top{
height: 40px;
background-color: #979090;
margin: 0px auto;
}
.title{
margin-top:5px;
color:#FFFFFF;
vertical-align: middle;
height: 40px;
float: left;
}
.user{
float: right;
width: 250px;
height: 40px;
color: #FFFFFF;
margin-top: 10px;
margin-right: 14px;
}
</style>
</head>
<body>
<div class="top">
<h3 class="title">电影租赁管理</h3>
<div class="user">用户：<b>
<c:if test="">

</c:if>
<c:choose>
<c:when test="${sessionScope.username!=null}">
${sessionScope.username} | <a href="${pageContext.request.contextPath}/logout.do">退出登录</a>
</c:when>
<c:otherwise>
未登录 | <a href="${pageContext.request.contextPath}/login.jsp">点击登录</a>
</c:otherwise>
</c:choose>
</b></div>
</div>
</body>
</html>