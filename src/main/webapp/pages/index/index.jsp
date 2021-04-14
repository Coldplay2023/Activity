<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>趣拓校园</title>
    <%@include file="/pages/common/head.jsp"%>


</head>
<body>

<div id="header">
    <span class="wel_word">趣拓校园</span>
    <div>
        <a href="studentServlet?action=showStudent">修改个人信息</a>|
        <a href="studentServlet?action=check">查看个人信息</a>
        <a href="index.jsp">首页</a>
    </div>
</div>
<div id="main">
    <div id="select">
        <form action="activityServlet" method="post">
            <input hidden="hidden" name="action" value="showIndex">
            <input name="vagueName" placeholder="请输入活动名" type="text" value="">
            <select name="vagueType">
                <option value="实践志愿类">实践志愿类</option>
                <option value="双创实训类" selected="selected">双创实训类</option>
                <option value="文体艺术类">文体艺术类</option>
                <option value="校园建设类">校园建设类</option>
            </select>
            <input type="submit" value="搜索"/>
        </form>
    </div>

    <div style="text-align: center">
        <span>${empty requestScope.msg ?"欢迎来到趣拓校园":requestScope.msg}</span>
        <div>
            <c:if test="${requestScope.activityName==null}">
                逛逛有什么活动想参加的吧！
            </c:if>
            <c:if test="${requestScope.activityName!=null&&requestScope.msg2==null}">
                您${requestScope.msg1}报名了<span style="color: red">${requestScope.activityName}</span>这个活动
            </c:if>
            <c:if test="${requestScope.msg2!=null}">
                提醒：<span style="color: red">${requestScope.activityName}</span>${requestScope.msg2}
            </c:if>
        </div>
    </div>

    <c:forEach items="${requestScope.page.items}" var="activity">
        <div class="b_list">
            <div class="img_div">
                <img class="book_img" alt="" src="static/img/GDUTShow.PNG" />
            </div>

            <div class="book_info">
                <div class="activityName">
                    <span class="sp1">活动名:</span>
                    <span class="sp2">${activity.activityName}</span>
                </div>
                <div class="activityContext">
                    <span class="sp1">活动内容:</span>
                    <span class="sp2">${activity.activityContext}</span>
                </div>
                <div class="activityType">
                    <span class="sp1">活动类型:</span>
                    <span class="sp2">${activity.activityType}</span>
                </div>
                <div class="activitySite">
                    <span class="sp1">活动地点:</span>
                    <span class="sp2">${activity.activitySite}</span>
                </div>
                <div class="activityStartTime">
                    <span class="sp1">活动开始时间:</span>
                    <span class="sp2">${activity.activityStartTime}</span>
                </div>
                <div class="activityOverTime">
                    <span class="sp1">活动结束时间:</span>
                    <span class="sp2">${activity.activityOverTime}</span>
                </div>
                <div class="activityTime">
                    <span class="sp1">活动时长:</span>
                    <span class="sp2">${activity.activityTime}</span>
                </div>
                <div class="activityPeople">
                    <span class="sp1">人数上限:</span>
                    <span class="sp2">${activity.activityPeople}</span>
                </div>
                <div class="activityStatus">
                    <span class="sp1">活动状态:</span>
                    <span class="sp2">${activity.activityStatus}</span>
                </div>
                <div class="join">
                    <a href="activityServlet?action=join&&activityId=${activity.id}&&activityName=${activity.activityName}&&pageNo=${requestScope.page.pageNo}">参加</a>
                </div>
            </div>
        </div>
    </c:forEach>

    </div>
</div>

<%--分页操作--%>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="activityServlet?action=showIndex&&pageNo=1">首页</a>
        <a href="activityServlet?action=showIndex&&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    ${[requestScope.page.pageNo]}
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="activityServlet?action=showIndex&&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="activityServlet?action=showIndex&&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input  name="pn" value="${param.pageNo}" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定" >
    <script>
        $(function () {
            $("#searchPageBtn").click(function (){
                var pageNo=$("#pn_input").val();
                //注意这个l是小写的
                location.href="${pageScope.basePath}activityServlet?action=showIndex&&pageNo="+pageNo;
            });
        });
    </script>
</div>


<div id="bottom">
    <%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>