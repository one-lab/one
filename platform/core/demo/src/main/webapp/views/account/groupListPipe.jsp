<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="/WEB-INF/rose.tld"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
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