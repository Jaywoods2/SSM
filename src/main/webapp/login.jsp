<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<h2>10111宾建武</h2>
	<div class="mainlogin">
	<h3 class="title">电影租赁管理系统</h3>
		<form action="${pageContext.request.contextPath}/login.do"
			method="post">
			<table class="tab">
				<tr>
					<td class="td1">用户名：</td>
					<td class="td2"><input  type="text" name="username" required /></td>
				</tr>
				<tr>
					<td class="td1">密 码：</td>
					<td class="td2"><input type="password" name="password" required /></td>
				</tr>
				<tr>
				<td>&nbsp;</td>
					<td><input id="loginbtn" type="submit" value="登录" /></td>
				</tr>
				<tr>
				<td>&nbsp;</td>
					<td>&nbsp;<c:if test="${error!=null}">
							<font color="red">${error}</font>
						</c:if></td>
				</tr>
			</table>
			<br /> <br />


		</form>
	</div>

</body>
</html>