<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="msg" uri="http://mvc.one.sinosoft.com/validation/msg" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>帐号管理</title>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<script type="text/javascript">
/*	$(document).ready(function() {
		// bind form using 'ajaxForm' 
		$('#inputForm').ajaxForm({
			dataType : "json",
			success : function(data) {
				if (data.status == "success") {
					alert(data.message);
					location.href = "${ctx}/account/user/list";
				}
			}
		});
	});
	function save() {
		$('#inputForm').submit();
	}
	*/</script>
</head>

<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content" class="span12">
	<form:form id="inputForm" modelAttribute="user" 
	action="${ctx}/account/user/saveValidator/${user.id}" method="post" enctype="multipart/form-data"
	class="form-horizontal">
		<input type="hidden" name="id" value="${user.id}"/>
		<fieldset>
			<legend><small>管理用户</small></legend>
			<div id="messageBox" class="alert alert-error" style="display:none">输入有误，请先更正。</div>
	
			<div class="control-group">
				<label for="loginName" class="control-label">登录名:</label>
				<div class="controls">
					<input type="text" id="loginName" name="loginName" size="50" value="${user.loginName}"/></div>
			</div>
			<div class="control-group">
				<label for="name" class="control-label">用户名:</label>
				<div class="controls">
					<input type="text" id="name" name="name" size="50" value="${user.name}"/></div>
			</div>
			<div class="control-group">
				<label for="password" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="password" name="password" size="50" value="${user.password}" class="required" minlength="3"/>
					<msg:errorMsg property="password" type="message" />				</div>
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
					<input type="text" id="email" name="email" size="50" value="${user.email}" class="email"/></div>
			</div>
			<div class="control-group">
				<label for="email" class="control-label">资料上传:</label>
				<div class="controls">
					<input type="file" id="doc" name="doc1" />
					<input type="file" id="doc2" name="doc2" />
				</div>
			</div>
			
			
			<div class="control-group">
				<label for="groupList" class="control-label">权限组:</label>
				<div class="controls">
						<form:checkboxes path="groupList" items="${allGroups}" itemLabel="name" itemValue="id" />
				</div>
			</div>	
			<fieldset>
			<div class="control-group">
				<legend>
						<small>用户隐私信息</small>
				</legend>
				<input type="hidden" name="userInfo.id" value="${userInfo.id}"/>
				<label for="userInfo.phone" class="control-label">手机号码：</label>
				<div class="controls">
					<input type="text" name="userInfo.phone" value="${userInfo.phone}" />
				</div>
				<br />
				<label for="userInfo.idcode" class="control-label">身份证号：</label>
				<div class="controls">
					<input type="text" name="userInfo.idcode" value="${userInfo.idcode}" />
				</div>
				<br />
				<label for="userInfo.gender" class="control-label">性别：     </label>
				<div class="controls">
					<input type="radio" value="MALE" name="userInfo.gender"  ${userInfo.strGender eq "MALE" || null == userInfo.strGender ? "checked='checked'" : ''}/>男性&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="FEMALE" name="userInfo.gender" ${userInfo.strGender eq "FEMALE" ? "checked='checked'" : ''}/>女性
				</div>
			</div>
			</fieldset>
			<div class="form-actions">
				<input id="submit" class="btn btn-primary" type="submit" value="提交" />&nbsp;	
				<input id="cancel" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
		
	</form:form>
	
	</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
</body>
</html>
