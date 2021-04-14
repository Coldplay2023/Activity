<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>审核学生</title>
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
    <span class="wel_word">审核学生</span>
    <%@include file="/pages/common/sponsorMenu.jsp"%>
</div>

<div id="main">
    <form action="book_manager.html">
        <table>
            <tr>
                <td>姓名</td>
                <td>学号</td>
                <td>年级学院</td>
                <td colspan="2">操作</td>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="student">
            <tr>
                <td>${student.name}</td>
                <td>${student.number}</td>
                <td>${student.grade_academe}</td>
                <td><a href="sponsorServlet?action=agree&&number=${student.number}&&pageNo=${requestScope.page.pageNo}">通过</a></td>
                <td><a href="sponsorServlet?action=disagree&&number=${student.number}&&pageNo=${requestScope.page.pageNo}">不通过</a></td>
            </tr>
            </c:forEach>
        </table>
    </form>
</div>
    <%--分页操作--%>
    <div id="page_nav">
        <c:if test="${requestScope.page.pageNo>1}">
            <a href="sponsorServlet?action=showStudentCS&&pageNo=1">首页</a>
            <a href="sponsorServlet?action=showStudentCS&&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        </c:if>
        ${[requestScope.page.pageNo]}
        <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
            <a href="sponsorServlet?action=showStudentCS&&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="sponsorServlet?action=showStudentCS&&pageNo=${requestScope.page.pageTotal}">末页</a>
        </c:if>

        共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
        到第<input  name="pn" value="${param.pageNo}" id="pn_input"/>页
        <input id="searchPageBtn" type="button" value="确定" >
        <script>
            $(function () {
                $("#searchPageBtn").click(function (){
                    var pageNo=$("#pn_input").val();
                    location.href="${pageScope.basePath}sponsorServlet?action=showStudentCS&&pageNo="+pageNo;

                });
            });
        </script>
    </div>


<div id="bottom">
    <%@include file="/pages/common/tail.jsp"%>
</div>
</body>
</html>