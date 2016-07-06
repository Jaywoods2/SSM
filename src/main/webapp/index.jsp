<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer.js"></script>
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
<h3>客户管理</h3>
<hr>
<div class="cuslist_title"><span>客户列表</span>
<a href="${pageContext.request.contextPath}/addcustomer1.do"><input type="button" value="新建"></a>
</div>
<table id="middle_tab" border="1" cellspacing="0">
<tr>
<td>操作</td>
<td>first_name</td>
<td>last_name</td>
<td>Address</td>
<td>Email</td>
<td>Customerid</td>
<td>lastupdate</td>
</tr>
</table>
<div>
<input type="hidden" id="pagecurpage" value="1"/>
<input type="hidden" id="pages"/>
<input type="button" value="《" onclick="uppage()"/>
<input type="text" size="3" id="selectcur" value="1"/>
<input type="button" value="跳转" onclick="jump()"/>
<input type="button" value="》" onclick="nextpage()"/>
</div>
</div>
</div>
</div>
</body>
</html>