<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看学生个人信息</title>
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
    <span class="wel_word">查看学生个人信息</span>
    <%@include file="/pages/common/StudentMenu.jsp"%>
</div>

<div id="main">
    <form action="">
        <table>
            <tr>
                <td>姓名</td>
                <td>学号</td>
                <td>年级学院</td>
                <td>时长</td>
            </tr>
            <tr>
                <td>${requestScope.student.name}</td>
                <td>${requestScope.student.number}</td>
                <td>${requestScope.student.grade_academe}</td>
                <td>${requestScope.student.time}</td>
            </tr>
        </table>
    </form>


</div>

<div id="bottom">
    <%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>