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
    
    <title>险种投保规则定义</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    <form name="fm" method="post"  id="frmInput">
	<div style = "width:80%">
	<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
			<tr>
				<td class="left">险种编码：</td>
				<td class="right"><input name="" class="common" type="text"/></td>
			</tr>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已有投保规则</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="16%">险种编码</td>
					<td width="16%">控制字段名称</td>
					<td width="16%">控制顺序号</td>
					<td width="16%">提示信息</td>
				</tr>
			</thead>
			<tbody align="center" id="HASCFdetail">
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td align="right" colspan="4">
					<input type = "button" class="cssbutton" name="InsertButton" value="新 增" onclick="insertCF();">
					<input type = "button" class="cssbutton" name="EditButton" value="修  改" onclick="updateCF();">
					<input type = "button" class="cssbutton" name="DeleteButton" value="删  除" onclick="deleteCF();">
					<input type = "button" class="cssbutton" id="save" name="SaveButton" value="保 存" onclick="saveCF();" >
				</td>
			</tr>
		</table>
		<table id="CFDetail" class="common" cellpadding="3" cellspacing="0" style="display: none">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">新增投保规则定义</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">序号</td>
					<td width="15%">属性名称</td>
					<td width="19%">属性数据类型</td>
					<td width="19%">属性值</td>
					<td width="23%">官方字段描述</td>
					<td width="19%">业务人员备注</td>
				</tr>
			</thead>
			<tbody align="center" id="CFContent" >
				
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="" value="进入算法定义" onclick="location.href='pdrisksortcaledit.jsp'">
				</td>
			</tr>
		</table>
		</div>
	</form>
  </body>
</html>
