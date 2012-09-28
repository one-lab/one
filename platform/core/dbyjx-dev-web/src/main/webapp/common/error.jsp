<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.text.*"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
	<head>
		<base href="<%=basePath%>">
		<title>呈报录入任务申请</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page"> 
		<script type="text/javascript">ctx = "${ctx}";</script>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		
</head>

<body >

<div>
	<table align="center" style="width:20%">
		<tr >
			<td></td>
			<td><h2><font color="red">sorry！发生异常了</font></h2></td>
		</tr>
	</table>
</div>
<div>
	<table  style="width:20%">
		<thead>
				<tr class="tableHead">
						<td >异常名称</td>
						<td >异常发生的方法</td>
				</tr>
		</thead>
		<tbody>
				<tr class="content">
						<td >${session.exception.name }</td>
						<td >${session.exception.actionName }</td>
				</tr>
		
		</tbody>
	</table>
</div>
<br>
<br>
<div>详细信息</div>
<div>
	<table  >
		<tr>
			<td><textarea rows="10" cols="100">${session.exception.message }</textarea></td>
		</tr>
	</table>
</div>
</body>
</html>