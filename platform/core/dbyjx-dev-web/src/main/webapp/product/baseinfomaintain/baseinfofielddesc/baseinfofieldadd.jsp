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
    
    <title>基础信息字段添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
	 <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:70%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">产品基础字段描述</td>
			</tr>
			<tr>
				<td class="left">产品基础表名：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">产品基础字段名</td>
				<td class="right">
					<input name="GrpName" class="common" type="text">
				</td>				
			</tr>
			<tr>
				<td class="left">字段值数据类型：</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" ></td>
				<td class="left">是否显示</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" >
				</td>				
			</tr>
		</table>
		</div>
		<div style = "width:100%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="left">官方字段描述</td>
				</tr>
				<tr>
					<td class="formtitle" colspan="6"><textarea name="" cols="" rows="4" ></textarea></td>
				</tr>
				<tr>
					<td class="left">业务人员备注</td>
				</tr>
				<tr>
					<td class="formtitle" colspan="6"><textarea name="" cols="" rows="4" ></textarea></td>
				</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="4">
					<input type = "button" class="cssbutton" name="SaveButton" value="保   存" onclick="">
					<input type = "button" class="cssbutton" name="BackButton" value="返   回" onclick="location.href='javascript:history.back()'">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
