<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>主办方账号编辑</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <span class="wel_word">学生个人信息修改</span>
    <%@include file="/pages/common/StudentMenu.jsp"%>
</div>

<div id="main">
    <form action="studentServlet" method="post">
        <input type="hidden" name="action" value="update">
        <table>
            <tr>
                <td>学号</td>
                <td>密码</td>
                <td>姓名</td>
                <td>年级-学院</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="number" type="text" value="${requestScope.student.number}"/></td>
                <td><input name="password" type="text" value="${requestScope.student.password}"/></td>
                <td><input name="name" type="text" value="${requestScope.student.name}"/></td>
                <td><input name="grade_academe" type="text" value="${requestScope.student.grade_academe}"/></td>
                <td><input type="submit" value="修改"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="bottom">
    <%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>