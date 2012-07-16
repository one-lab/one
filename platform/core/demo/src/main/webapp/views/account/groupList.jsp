<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="/WEB-INF/rose.tld"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>帐号管理</title>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<script>
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#group-tab").addClass("active");
	});
</script>
</head>

<body>

	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content" class="span12">
			<h4>权限组列表</h4>
			<c:if test="${not empty message}">
				<div id="message" class="alert alert-success">
					<button data-dismiss="alert" class="close">×</button>
					${message}
				</div>
			</c:if>
			<table id="contentTable"
				class="table table-striped table-bordered table-condensed">
				<tr>
					<th>名称</th>
					<th>授权</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${groups}" var="group">
					<tr>
						<td>${group.name}</td>
						<td>${group.permissionNames}</td>
						<td><a href="update/${group.id}" id="editLink-${group.name}">修改</a>
							<a href="delete/${group.id}">删除</a></td>
					</tr>
				</c:forEach>
			</table>

			<a class="btn" href="create">创建权限组</a>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>



</body>
</html>
