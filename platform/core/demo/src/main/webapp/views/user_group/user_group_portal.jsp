<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://paoding.net/rose/pipe" prefix="rosepipe"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${ctx}/static/portal.css" rel="stylesheet" type="text/css"
	media="all" />
<title>帐号及权限信息(portal)</title>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<script src="${ctx}/static/rose-pipe/rose-pipe.js"
	type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	//聚焦第一个输入框
	$("#portal-tab").addClass("active");
});
</script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content" class="span12">
			<h2>帐号及权限信息：</h2>

			<div class="window">
				<div class="title">用户</div>
				<!--这里使用$weather的"weather"即是第一个window的标识-->
				<div class="content">${p1}</div>
			</div>

			<div class="window">
				<div class="title">权限</div>
				<!--$todo实际是一个Window对象，velocity会调用其toString()输出html的-->
				<div class="content">${p2}</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
</body>
</html>

