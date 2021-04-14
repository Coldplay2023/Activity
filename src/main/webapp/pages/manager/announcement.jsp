<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>发布公告</title>
    <%@include file="/pages/common/head.jsp"%>

    <script type="text/javascript">
        $(function (){
            $("#delete").click(function (){
                //返回true表示确认，返回false表示取消
                return confirm("你确定要删除公告吗");
            });
            $("#update").click(function (){
                //返回true表示确认，返回false表示取消
                return confirm("你确定要发布公告吗");
            });
        });
    </script>

</head>
<body>

<div id="header">
    <span class="wel_word">发布公告</span>
    <%@include file="/pages/common/managerMenu.jsp"%>
</div>

<div id="main">
    <form action="announcementServlet" method="post">
        <input hidden="hidden" name="action" value="updateAnnouncement">
        <input hidden="hidden" name="bool" value="update">
        <table>
            <tr>
                <td><textarea name="context" rows="10" cols="50">${requestScope.context}</textarea></td>
                <td><input id="update" type="submit" value="发布公告"  /></td>
                <td><input id="delete" type="button" value="删除公告" onclick="window.location.href='announcementServlet?action=updateAnnouncement&&bool=delete'" /></td>
            </tr>
        </table>

    </form>

</div>

<div id="bottom">
    <%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>