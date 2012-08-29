
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
    
    <title>算法模板库添加</title>
    
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
	<div style = "width:100%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">算法模板库</td>
			</tr>
			<tr>
				<td class="left">算法模板编码</td>
				<td class="right"><input name="" class="common" type="text"></td>
				<td class="left">算法模板名称</td>
				<td class="right"><input name="" class="common" type="text"></td>				
			</tr>
			<tr>
				<td class="left">算法模板类型：</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:65%"></td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="left">算法模板内容</td>
				</tr>
				<tr>
					<td class="formtitle" colspan="6"><textarea name="" cols="" rows="4" ></textarea></td>
				</tr>
				<tr>
					<td class="left">算法模板描述</td>
				</tr>
				<tr>
					<td class="formtitle" colspan="6"><textarea name="" cols="" rows="4" ></textarea></td>
				</tr>
				<tr>
				<td>
					<input type = "button" class="cssbutton" name="QueryButton" value="保 存" onclick="">
				</td>
				<td>
					<input type = "button" class="cssbutton" name="QueryButton" value="返 回" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>