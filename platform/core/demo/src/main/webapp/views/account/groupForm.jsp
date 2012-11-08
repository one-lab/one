<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>帐号管理</title>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<script>
	$(document).ready(function() {
		
		$("#group-tab").addClass("active");
		$("#inputForm").validate();
	});
</script>
</head>

<body>


	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content" class="span12">
			<form:form id="inputForm" modelAttribute="group"
				action="${ctx}/account/group/save/${group.id}" method="post"
				class="form-horizontal">
				<input type="hidden" name="id" value="${group.id}" />
				<fieldset>
					<legend>
						<small>管理权限组</small>
					</legend>
					<div class="control-group">
						<label for="name" class="control-label">名称:</label>
						<div class="controls">
							<input type="text" id="name" name="name" size="50"
								class="required" value="${group.name}" />
						</div>
					</div>
					<div class="control-group">
						<label for="permissionList" class="control-label">权限列表:</label>
						<div class="controls">
							<form:checkboxes path="permissionList" items="${allPermissions}"
								itemLabel="displayName" itemValue="value" />
						</div>
					</div>
					<div class="form-actions">
						<input id="submit" class="btn btn-primary" type="submit"
							value="提交" />&nbsp; <input id="cancel" class="btn" type="button"
							value="返回" onclick="history.back()" />
					</div>
				</fieldset>
			</form:form>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>



</body>
</html>
