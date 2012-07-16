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
	$("#pipe-tab").addClass("active");
});
</script>
</head>
<body>
<div class="content" id="p1"></div>
<div class="content" id="p2"></div>
</body>
</html>
<rosepipe:write>${p1}</rosepipe:write>
<rosepipe:write>${p2}</rosepipe:write>

