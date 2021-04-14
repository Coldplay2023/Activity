<%--
  Created by IntelliJ IDEA.
  User: COLDPLAY
  Date: 2021/3/31
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>提醒页面</title>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: #ff0000;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/GDUTHead.PNG" >
    <%@include file="/pages/common/sponsorMenu.jsp"%>
</div>

<div id="main">

    <h1>发布成功<a href="pages/sponsor/sponsor.jsp">转到主办方主页</a></h1>

</div>

<div id="bottom">
			<span>
				 <%@include file="/pages/common/tail.jsp"%>
			</span>
</div>
</body>
</html>
