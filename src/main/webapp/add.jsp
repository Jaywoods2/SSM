<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户信息</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css">
	<style type="text/css">
	#addform{
	width: 300px;
	height: 160px;
	margin: 10px auto;
	}
	#addform input{
	height: 30px;
	}
	#addform select{
	height: 20px;
	}
	</style>
</head>
<body>
<div class="mainbody">
<jsp:include page="top.jsp"></jsp:include>
<div class="main">
<div class="leftmenu">
<ul class="menu1">
<li><a href="${pageContext.request.contextPath}/index.jsp">Customer管理</a></li>
<li>Film设置</li>
</ul>
</div>
<div class="middle">
<h3>创建Customer</h3>
<hr>
<div class="cuslist_title">
基本信息
</div>
<div id="addform">
<form  action="${pageContext.request.contextPath}/addcustomer2.do" method="post">
First Name:<input type="text" name="firstName" required/><br/><br/>
Last  Name:<input type="text" name="lastName" required/><br/><br/>
　　Email:<input type="text" name="email" required/><br/><br/>
　　Address:<select name="addressId" requireds>
				<c:forEach items="${addresslist}" var="address">
				<option value="${address.address_id}">${address.address}</option>
				</c:forEach>
			</select><br/><br/>
　　　　　　　　<input type="submit" value="新建"/>
<input type="reset" value="取消"/>
</form>
<c:if test="${addErr!=null}">
<font color="red">${addErr}</font>
</c:if>
</div>
</div>
</div>
</div>
</body>
</html>