<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="header" class="span12">
	<div id="title">
			<a href="${ctx}/logout" style="float:right;margin-top:14px"><font size="2">退出登录&nbsp; </font></a>
	    	<h1>
	    	platformDemo<small>--CRUD管理界面演示
	    	</small></h1>
	    	
<%-- 	    	<span align="left"><a href="${ctx}/logout"><small>退出登录</small></a></span> --%>
			<span class="pull-right"> ${date}&nbsp;&nbsp;${welInfo}</span>
	</div>
		
	<div id="menu">
		<ul class="nav nav-tabs">
				<li class="active"><a href="${ctx}/login">登录</a></li>
				<li id="user-tab"><a href="${ctx}/account/user/" >帐号列表</a></li>
				<li id="group-tab"><a href="${ctx}/account/group/">权限组列表</a></li>
				<li id="pipe-u-g"><a href="${ctx}/user_group/pipe">帐号及权限信息(pipe)</a></li>
				
		</ul>
	</div>
</div>


