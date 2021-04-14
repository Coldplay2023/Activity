<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理</title>
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
    <span class="wel_word">学生信息管理系统</span>
    <%@include file="/pages/common/StudentMenu.jsp"%>
</div>

<div id="main">
    <h1>欢迎学生进入学生信息系统</h1>
</div>

<div id="bottom">
    <%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>