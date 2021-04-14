<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>账号审核</title>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
	<span class="wel_word">主办方账号审核</span>
	<%@include file="/pages/common/managerMenu.jsp"%>
</div>

<div id="main">
	<table>
		<tr>
			<td>账号</td>
			<td>负责人名字</td>
			<td>负责人联系方式</td>
			<td>社团名</td>
			<td>社团简介</td>
			<td colspan="2">操作</td>
		</tr>
		<c:forEach items="${requestScope.page.items}" var="sponsor">
			<tr>
				<td>${sponsor.account}</td>
				<td>${sponsor.principalName}</td>
				<td>${sponsor.principalContact}</td>
				<td>${sponsor.clubName}</td>
				<td>${sponsor.clubIntroduction}</td>
				<td><a href="managerServlet?action=agreeSponsor&&sponsorId=${sponsor.id}&&pageNo=${requestScope.page.pageNo}">通过</a></td>
				<td><a href="managerServlet?action=disagreeSponsor&&sponsorId=${sponsor.id}&&pageNo=${requestScope.page.pageNo}">不通过</a></td>
			</tr>
		</c:forEach>

	</table>
</div>
<%--分页操作--%>
<div id="page_nav">
	<c:if test="${requestScope.page.pageNo>1}">
		<a href="managerServlet?action=checkSponsor&&pageNo=1">首页</a>
		<a href="managerServlet?action=checkSponsor&&pageNo=${requestScope.page.pageNo-1}">上一页</a>
	</c:if>
	${[requestScope.page.pageNo]}
	<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
		<a href="managerServlet?action=checkSponsor&&pageNo=${requestScope.page.pageNo+1}">下一页</a>
		<a href="managerServlet?action=checkSponsor&&pageNo=${requestScope.page.pageTotal}">末页</a>
	</c:if>

	共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
	到第<input  name="pn" value="${param.pageNo}" id="pn_input"/>页
	<input id="searchPageBtn" type="button" value="确定" >
	<script>
		$(function () {
			$("#searchPageBtn").click(function (){
				var pageNo=$("#pn_input").val();
				location.href="${pageScope.basePath}managerServlet?action=checkSponsor&&pageNo="+pageNo;
			});
		});
	</script>


</div>
<div id="bottom">
	<%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>