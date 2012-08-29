<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>险种角色定义</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    
	<div style = "width:80%">
	    <table id="" class="common" cellpadding="3" cellspacing="0" style="width:40%">
			<tr>
				<td class="left" >产品险种编码：</td>
				<td class="right" style="width:20%"><input name="" class="common" type="text"/></td>
			</tr>
		</table>
	    <table id="" class="common" cellpadding="3" cellspacing="0" >
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已保存险种各角色定义</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="10%">险种编码</td>
					<td width="10%">险种版本</td>
					<td width="10%">角色</td>
					<td width="10%">性别</td>
					<td width="10%">序号（级别）</td>
					<td width="10%">最小年龄单位</td>
					<td width="10%">最小年龄</td>
					<td width="10%">最大年龄单位</td>
					<td width="10%">最大年龄</td>
				</tr>
			</thead>
			<tbody align="center" id="roleList">
			</tbody>
		</table>
		
		<table id="" class="common" cellpadding="3" cellspacing="0">
		    <tr>
				<td align="right" colspan="4">
					<input type = "button" class="cssbutton" id="addRiskRole" value="新  增" onclick="addRiskRole()">
					<input type = "button" class="cssbutton" id="updateRiskRole" value="修  改" onclick="updateRiskRole()">
					<input type = "button" class="cssbutton" name="DeleteButton" value="删  除" onclick="deleteRiskRole()">
					<input type = "button" class="cssbutton" id="saveriskRole" value="保  存" onclick="saveRiskRole()">
					<input id="operateRole" type="hidden"/>
				</td>
			</tr>
		</table>
		<form id="riskRoleForm">
		<table id="riskRole" class="common" cellpadding="3" cellspacing="0" style="display: none">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种各角色定义</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="4%">序号</td>
					<td width="16%">属性名称</td>
					<td width="16%">属性代码</td>
					<td width="16%">属性数据类型</td>
					<td width="16%">属性值</td>
					<td width="16%">官方字段描述</td>
					<td width="16%">业务人员备注</td>
				</tr>
			</thead>
			<tbody align="center" id="oneRole">
			</tbody>
		</table>
		</form>
		</div>
	
  </body>
</html>
