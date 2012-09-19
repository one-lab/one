<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>保全受理</title>
    
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
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保全受理信息</td>
			</tr>
			<tr> 
				<td class="left">保全受理号：</td>
				<td class="right"><input name="EndorAcceptNo" class="common" type="text" readonly></td>
				<td class="left">保全申请书号码：</td>
				<td class="right"><input name="EndorApplyNo" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr> 
				<td class="left">团体合同号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">申请单位名称：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">批改状态：</td>
				<td class="right"><input name="State" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">申请方式：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%">
				</td>
				<td class="left">受理日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28' readonly>
				</td>
				<td class="common"></td>
				<td class="common"></td>		
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="确  定" onclick="location.href='./GrpEndorApplyAccept.jsp'">
					<input type = "button" class="cssbutton" name="ReturnBack" value="返  回" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
