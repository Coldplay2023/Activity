<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>活动编辑</title>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <span class="wel_word">活动编辑</span>
    <%@include file="/pages/common/sponsorMenu.jsp"%>
</div>

<div id="main1">

        <table>
            <tr>
                <td>活动名</td>
                <td>活动类型</td>
                <td>活动内容</td>
                <td>活动地点</td>
                <td>活动开始时间</td>
                <td>活动结束时间</td>
                <td>活动时长</td>
                <td>人数上限</td>
                <td>活动状态</td>
                <td colspan="2">操作</td>
            </tr>

                <c:forEach items="${requestScope.page.items}" var="activity">
               <form action="activityServlet" method="post">
                <input hidden="hidden" name="action" value="update">
                <tr>
                    <td><input name="activityName" type="text" value="${activity.activityName}"/></td>
                    <td><input name="activityType" type="text" value="${activity.activityType}"/></td>
                    <td><input name="activityContext" type="text" value="${activity.activityContext}"/></td>
                    <td><input name="activitySite" type="text" value="${activity.activitySite}"/></td>
                    <td><input name="activityStartTime" type="text" value="${activity.activityStartTime}"/></td>
                    <td><input name="activityOverTime" type="text" value="${activity.activityOverTime}"/></td>
                    <td><input name="activityTime" type="text" value="${activity.activityTime}"/></td>
                    <td><input name="activityPeople" type="text" value="${activity.activityPeople}"/></td>
                    <td><input name="activityStatus" disabled="disabled" type="text" value="${activity.activityStatus}"/></td>
                    <input hidden="hidden" name="id" value="${activity.id}"/>
                    <input hidden="hidden" name="pageNo" value="${requestScope.page.pageNo}"/>
                    <td><input type="submit" value="修改" /></td>
                    <td><a href="activityServlet?action=deleteActivity&&activityId=${activity.id}&&pageNo=${requestScope.page.pageNo}&&method=editActivity">撤销</a></td>
               </tr>
               </form>
                </c:forEach>

        </table>
</div>
    <%--分页操作--%>
    <div id="page_nav">
        <c:if test="${requestScope.page.pageNo>1}">
            <a href="activityServlet?action=queryActivity&&pageNo=1">首页</a>
            <a href="activityServlet?action=queryActivity&&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        </c:if>
        ${[requestScope.page.pageNo]}
        <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
            <a href="activityServlet?action=queryActivity&&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="activityServlet?action=queryActivity&&pageNo=${requestScope.page.pageTotal}">末页</a>
        </c:if>

        共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
        到第<input  name="pn" value="${param.pageNo}" id="pn_input"/>页
        <input id="searchPageBtn" type="button" value="确定" >
        <script>
            $(function () {
                $("#searchPageBtn").click(function (){
                    var pageNo=$("#pn_input").val();
                    location.href="${pageScope.basePath}activityServlet?action=queryActivity&&pageNo="+pageNo;

                });
            });
        </script>


</div>

<div id="bottom">
    <%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>