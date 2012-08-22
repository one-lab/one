<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>帐号管理</title>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		//聚焦第一个输入框 
		$("#user-tab").addClass("active");
	});
	
</script>


</head>

<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content" class="span12">
			<h4>用户列表</h4>
			<c:if test="${not empty message}">
				<div id="message" class="alert alert-success">
					<button data-dismiss="alert" class="close">×</button>
					<d:flash key="message"></d:flash>
				</div>

			</c:if>

			<table id="contentTable"
				class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th>登录名</th>
						<th>用户名</th>
						<th>邮箱</th>
						<th>权限组</th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.loginName}</td>
							<td>${user.name}</td>
							<td>${user.email}</td>
							<td>${user.groupNames}</td>
							<td><fmt:formatDate value="${user.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
							<td><a href="update/${user.id}" id="editLink-${user.name}">修改</a>
								<a href="javascript:void(0);" onClick="viewUser(${user.id});" id="viewLink-${user.name}">查看</a> 
								<a href="delete/${user.id}">删除</a>
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a class="btn" href="create">创建用户</a>
			
		</div>

		<div id="view" class="span12" style="display: none">

			<form:form id="inputForm" modelAttribute="user" class="form-horizontal">
				<input type="hidden" name="id" value="${user.id}" />
				<fieldset>
					<legend>
					<a href="javascript:void(0)" onclick="closeView();" style="float:right;margin-top:14px"><font size="2">关闭&nbsp; </font></a>	
						<small>用户基本信息</small>
					</legend>

 					<div class="control-group"> 
						<label for="loginName" class="control-label">登录名:</label>
						<div class="controls">
							<input type="text" id="loginName" name="loginName" size="50" class="required" />
						</div>
					</div>
					<div class="control-group">
						<label for="name" class="control-label">用户名:</label>
						<div class="controls">
							<input type="text" id="name" name="name" size="50" class="required" />
						</div>
					</div>
					<div class="control-group">
						<label for="email" class="control-label">邮箱:</label>
						<div class="controls">
							<input type="text" id="email" name="email" size="50" class="email" />
						</div>
					</div>
					
					<div class="control-group">
						<label for="groupList" class="control-label">权限信息:</label>
						<div  class="controls" id="groupListDiv"></div>
 					</div> 
					
				</fieldset>
				
				<fieldset>
					<legend>
					<a href="javascript:void(0)" onclick="closeView();" style="float:right;margin-top:14px"><font size="2">关闭&nbsp; </font></a>	
						<small>用户隐私信息</small>
					</legend>

 					<div class="control-group"> 
						<label  class="control-label">手机号码:</label>
						<div class="controls">
							<input type="text" id="phone"  size="50" class="required" />
						</div>
					</div>
					<div class="control-group">
						<label  class="control-label">身份证号:</label>
						<div class="controls">
							<input type="text" id="idcode" size="50" class="required" />
						</div>
					</div>
					<div class="control-group">
						<label  class="control-label">性别:</label>
						<div class="controls">
							<input type="text" id="gender"  size="50" class="email" />
						</div>
					</div>
				</fieldset>
			</form:form>

		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
<script type="text/javascript">
var viewUser=function (uId) {
		$.ajax({
			type : "post",
			url : "${ctx}/account/user/view/1/2/"+uId,
			dataType : "json",
			success : function(data) {
				if(data != null){
					$("#loginName").val(data.loginName);
					$("#name").val(data.name);
					$("#email").val(data.email);
					$("#groupListDiv").html("");
					for (var i=0;i < data.groupList.length;i++){
					    $("#groupListDiv").append("<span>["+data.groupList[i].permissionNames+"]</span><br/>");
					    
					}
					
					$("#view").show();
				}
			},
			error:function(){
				alert("暂时无法获取用户信息");
			}
		});
		
		$.ajax({
			type : "post",
			url : "${ctx}/account/user/viewUserInfo/"+uId,
			dataType : "json",
			success : function(data) {
				if(data != null){
					$("#phone").val(data.phone);
					$("#idcode").val(data.idcode);
					var gender = data.strGender;
					
					$("#gender").val(gender=="MALE" ? "男性":"女性");
					
					$("#view").show();
				}
			},
			error:function(){
				alert("暂时无法获取隐私信息");
			}
		});
	}
var closeView = function(){
	$("#view").hide();
}
</script>
</body>
</html>
