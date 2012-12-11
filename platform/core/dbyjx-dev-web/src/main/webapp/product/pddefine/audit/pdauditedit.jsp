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
    
    <title>产品审核明细</title>
    
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
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种缴费责任</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="24%">险种代码</td>
					<td width="24%">缴费责任代码</td>
					<td width="24%">缴费责任名称</td>
					<td width="24%">可选标记</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种给付责任</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="24%">险种代码</td>
					<td width="24%">给付责任代码</td>
					<td width="24%">给付责任名称</td>
					<td width="24%">关联缴费责任代码</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="5">
					<input type = "button" class="cssbutton" name="Button" value="查看产品基础定义" onclick="location.href='../baseinfodefine/pdlmriskedit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="查看契约定义" onclick="location.href='../policydefine/pdpolicyedit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="查看保全定义" onclick="location.href='../endordefine/pdendoredit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="查看理赔定义 " onclick="location.href='../claimdefine/pdclaimedit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="查看保监会报表定义" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="查看销售定义" onclick="">
				</td>
			</tr>
			<tr>
				<td colspan="5">
					<input type = "button" class="cssbutton" name="Button" value="记事本" onclick="location.href='../baseinfodefine/pdlmrisknotepadedit.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="问题件查询" onclick="location.href='../baseinfodefine/pdissueview.jsp'">
					<input type = "button" class="cssbutton" name="Button" value="问题件录入" onclick="location.href='../policydefine/pdissueedit.jsp'">
				</td>
			</tr>
			<tr>
				<td colspan="5">
					<input type = "button" class="cssbutton" name="Button" value="审核完毕" onclick="">
					<input type = "button" class="cssbutton" name="Button" value="返回" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
