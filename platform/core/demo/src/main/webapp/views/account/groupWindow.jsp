<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="/WEB-INF/rose.tld"%>
<%@ taglib uri="http://paoding.net/rose/pipe" prefix="rosepipe"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐号管理</title>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
</head>

<body>

			<table id="contentTable"
				class="table table-striped table-bordered table-condensed">
				<tr>
					<th>名称</th>
					<th>授权</th>
				</tr>
				<c:forEach items="${groups}" var="group">
					<tr>
						<td>${group.name}</td>
						<td>${group.permissionNames}</td>
					</tr>
				</c:forEach>
			</table>

</body>
</html>
