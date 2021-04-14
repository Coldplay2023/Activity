<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>趣拓校园</title>
	<%@include file="/pages/common/head.jsp"%>
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}
	</style>
</head>
<body>
	
	<div id="header">
			<span class="wel_word">趣拓校园</span>
			<div>
				<a href="pages/user/userLogin.jsp">用户登录</a> |
				<a href="pages/user/userRegister.jsp">用户注册</a>|
				<a href="pages/user/sponsorLogin.jsp">活动主办方登录</a>|
				<a href="pages/user/sponsorRegister.jsp">活动主办方注册</a>|
				<a href="pages/user/managerLogin.jsp">系统管理员</a>
			</div>
	</div>

	<div id="main">
		<h1>欢迎来到趣拓管理系统:请先登录或者注册</h1>
	</div>

	<div id="bottom">
		<%@include file="/pages/common/tail.jsp"%>
	</div>
</body>
</html>