<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>发布活动</title>
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

			<span class="wel_word">发布活动</span>
			<%@include file="/pages/common/sponsorMenu.jsp"%>
		</div>
		
		<div id="main">
			<form action="fileServlet" method="post" enctype="multipart/form-data">
				<input type="hidden" name="action" value="releaseActivity">
				<table>
					<tr>
						<td>活动名</td>
						<td>活动类型</td>
						<td>活动内容</td>
						<td>活动地点</td>
						<td>活动开始时间</td>
						<td>活动结束时间</td>
						<td>活动时长</td>
						<td>人数上限</td>
						<td>添加文件</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="activityName" type="text" value=""/></td>
						<td><input name="activityType" type="text" value=""/></td>
						<td><input name="activityContext" type="text" value=""/></td>
						<td><input name="activitySite" type="text" value=""/></td>
						<td><input name="activityStartTime" type="text" value=""/></td>
						<td><input name="activityOverTime" type="text" value=""/></td>
						<td><input name="activityTime" type="text" value=""/></td>
						<td><input name="activityPeople" type="text" value=""/></td>
						<td><input name="file" type="file" value="上传文件"/></td>
						<td><input type="submit" value="发布"/></td>
					</tr>	
				</table>
			</form>
		</div>
		
		<div id="bottom">
			<%@include file="/pages/common/tail.jsp"%>
		</div>
</body>
</html>