<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面</title>
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
    <%@include file="/pages/common/StudentMenu.jsp"%>
</div>

<div id="main">
    <h1>欢迎来到趣拓管理系统:<a href="activityServlet?action=showIndex&&pageNo=1">点击进入活动首页</a></h1>
</div>

<div id="bottom">
    <%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>