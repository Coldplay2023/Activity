<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统管理员登录页面</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/GDUTHead.PNG" >
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>系统管理员</h1>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">${empty requestScope.msg?"请输入用户名和密码":requestScope.msg}</span>
                </div>
                <div class="form">
                    <form action="managerServlet" method="post">
                        <input hidden="hidden" name="action" value="login">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入管理员账号" autocomplete="off" tabindex="1" name="managerAccount" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="managerPassword" />
                        <br />
                        <br />
                        <input type="submit" value="登录" id="sub_btn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="bottom">
    <%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>