<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>主办方账号编辑</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <span class="wel_word">主办方账号编辑</span>
    <%@include file="/pages/common/sponsorMenu.jsp"%>
</div>

<div id="main">
    <form action="sponsorServlet" method="post">
         <input hidden="hidden" name="action" value="update">
    <table>
        <tr>
            <td>账号</td>
            <td>密码</td>
            <td>负责人名字</td>
            <td>负责人联系方式</td>
            <td>社团名</td>
            <td>社团简介</td>
            <td colspan="2">操作</td>
        </tr>
        <tr>
            <td><input name="account" type="text" value="${requestScope.sponsor.account}"/></td>
            <td><input name="password" type="text" value="${requestScope.sponsor.password}"/></td>
            <td><input name="principalName" type="text" value="${requestScope.sponsor.principalName}"/></td>
            <td><input name="principalContact" type="text" value="${requestScope.sponsor.principalContact}"/></td>
            <td><input name="clubName" type="text" value="${requestScope.sponsor.clubName}"/></td>
            <td><input name="clubIntroduction" type="text" value="${requestScope.sponsor.clubIntroduction}"/></td>
            <input hidden="hidden" name="id" value="${requestScope.sponsor.id}"/>
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