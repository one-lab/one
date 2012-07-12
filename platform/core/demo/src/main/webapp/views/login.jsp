<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>登录页</title>

</head>

<body>
	<form id="loginForm" action="${ctx}/login" method="post" class="form-horizontal">

			<div class="control-group">
				<label for="username" class="control-label">名称:</label>
				<div class="controls">
					<input type="text" id="loginName" name="loginName" size="50" value="${loginName}" class="required span2"/>
				</div>
			</div>
			<div class="control-group">
				<label for="password" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="password" name="password" size="50"  class="required span2"/>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
				<label class="checkbox inline" for="rememberMe"> <input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我</label>
				<input id="submit" class="btn" type="submit" value="登录"/>
				<p class="help-block">(管理员<b>admin/admin</b>, 普通用户<b>kylin/kylin</b>)</p>
				</div>
			</div>
		
	</form>
</body>
</html>
