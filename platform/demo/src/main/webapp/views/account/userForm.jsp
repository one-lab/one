<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="d" uri="/WEB-INF/rose.tld" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>帐号管理</title>
	
</head>

<body>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/account/user/save/${user.id}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${user.id}"/>
		<fieldset>
			<legend><small>管理用户</small></legend>
			<div id="messageBox" class="alert alert-error" style="display:none">输入有误，请先更正。</div>
	
			<div class="control-group">
				<label for="loginName" class="control-label">登录名:</label>
				<div class="controls">
					<input type="text" id="loginName" name="loginName" size="50" value="${user.loginName}" class="required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="name" class="control-label">用户名:</label>
				<div class="controls">
					<input type="text" id="name" name="name" size="50" value="${user.name}" class="required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="password" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="password" name="password" size="50" value="${user.password}" class="required" minlength="3"/>
				</div>
			</div>
			<div class="control-group">
				<label for="passwordConfirm" class="control-label">确认密码:</label>
				<div class="controls">
					<input type="password" id="passwordConfirm" name="passwordConfirm" size="50" value="${user.password}" equalTo="#password"/>
				</div>
			</div>
			<div class="control-group">
				<label for="email" class="control-label">邮箱:</label>
				<div class="controls">
					<input type="text" id="email" name="email" size="50" value="${user.email}" class="email"/>
				</div>
			</div>
			<div class="control-group">
				<label for="groupList" class="control-label">权限组:</label>
				<div class="controls">
					<form:checkboxes path="groupList" items="${allGroups}" itemLabel="name" itemValue="id" />
				</div>
			</div>	
			<div class="form-actions">
				<input id="submit" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>

	</form:form>
	<form id="uploadForm" action="${ctx}/upload" method="post" enctype="application/x-www-form-urlencoded" class="form-horizontal">

			<div class="control-group">
				<label for="username" class="control-label">名称:</label>
				<div class="controls">
					<input type="file" id="loginName" name="files"class="required span2"/>
				</div>
			</div>
			
			<div class="control-group">
				<div class="controls">
				<label class="checkbox inline" for="rememberMe"> <input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我</label>
				<input id="submit" class="btn" type="submit" value="登录"/>
				<p class="help-block">(文件上传)</p>
				</div>
			</div>
		
	</form>
</body>
</html>
