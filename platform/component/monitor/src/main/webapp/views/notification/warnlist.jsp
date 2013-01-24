<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://mvc.one.sinosoft.com/tags/pipe" prefix="mvcpipe"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="appName" value="appName" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${ctx}/static/portal.css" rel="stylesheet" type="text/css"
	media="all" />
<title>预警信息</title>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<script src="${ctx}/static/mvc-pipe/mvc-pipe.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#warn-tab").addClass("active");
	});
</script>
<script type="text/javascript">
function queryByChange() {
	var redirectUrl="${ctx}/notification/notification/list?appName="+$("#appSelected option:selected").attr("id");
	location.href=redirectUrl;
	
	/* $("#appForm").submit();
	var urlPaht="${ctx}/notification/urlConfigure/test";
	alert($("#appSelected option:selected").attr("id"));
	$.ajax({
		type : "post",
		url : "${ctx}/notification/appConfigure/reflashList?appName="+$("#appSelected option:selected").attr("id"),
		dataType : "json",
		success : function(data) {
			var redirectUrl='${ctx}'+data.message;
			location.href = redirectUrl;
		},
		error : function(data) {
			alert(data+"暂时无法获取应用列别信息.");
		}
	});  */
}
</script>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content" class="span12" >
		<h2>预警信息：</h2>
		<div>
				<select id="appSelected" onchange="queryByChange()">
					<option id="">请选择应用</option>
					<c:forEach items="${app}" var="appList">
						<option id="${appList.id}">${appList.name }</option>
					</c:forEach>
				</select>
					当前所选应用:
			</div>
			<div class="window">
				<div class="content">
					<table id="contentTableUrl"
						class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>名称</th>
								<th>内容</th>
								<th>等级</th>
								<th>来自模块</th>
								<th>备注</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${warn}" var="warn">
								<tr>
									<td>${warn.title }</td>
									<td>${warn.content }</td>
									<td>${warn.grade }</td>
									<td>${warn.module }</td>
									<td>${warn.remark }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
	
</body>
</html>
