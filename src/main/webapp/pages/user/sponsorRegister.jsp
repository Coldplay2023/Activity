<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>活动主办方注册页面</title>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#account").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("用户名不合法！");

                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法！");

                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

            });

        });

    </script>

</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/GDUTHead.PNG" >
</div>

<div class="register_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="Register_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册活动主办方</h1>
                    <span class="errorMsg">${requestScope.msg}</span>
                </div>
                <div class="form">
                    <form action="sponsorServlet" method="post">
                        <input type="hidden" name="action" value="register">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名(数字字母下划线5-12位)"
                               autocomplete="off" tabindex="1" name="account" id="account" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码(数字字母下划线5-12位)"
                               autocomplete="off" tabindex="1" name="password" id="password" />
                        <br />
                        <br />
                        <label>社团名：</label>
                        <input class="itxt" type="text" placeholder="请输入社团名"
                               autocomplete="off" tabindex="1" name="clubName" id="clubName" />
                        <br />
                        <br />
                        <label>负责人名字：</label>
                        <input class="itxt" type="text" placeholder="请输入负责人名字"
                               autocomplete="off" tabindex="1" name="principalName" id="principalName" />
                        <br />
                        <br />
                        <label>负责人联系方式：</label>
                        <input class="itxt" type="text" placeholder="请输入负责人联系方式"
                               autocomplete="off" tabindex="1" name="principalContact" id="principalContact" />
                        <br />
                        <br />
                        <label>社团简介</label>
                        <input class="itxt" type="text" placeholder="请输入社团简介"
                               autocomplete="off" tabindex="1" name="clubIntroduction" id="clubIntroduction" />
                        <br />
                        <br />
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" id="code"/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br />
                        <br />
                        <input type="submit" value="注册" id="sub_btn" />

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





























