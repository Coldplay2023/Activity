<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>公告</title>
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
    <span class="wel_word">公告</span>
    <%@include file="/pages/common/StudentMenu.jsp"%>
</div>

<div id="main">
    <h1>${empty requestScope.context ?"管理员还没有发布公告" : requestScope.context}</h1>
</div>

<div id="bottom">
    <%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>