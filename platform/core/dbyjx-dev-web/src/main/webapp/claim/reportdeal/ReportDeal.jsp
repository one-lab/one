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
    
	    <title>呈报处理</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>
<body>
	<form name="fm" method="post" onKeyPress="KeyDown()">
	<div style="width:100%">
		<table id="ReportInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">选中呈报的信息</td>
			</tr>
			<tr>
				<td class="left">报案号：</td>
				<td class="right"><input name="reportNo" class="common" type="text" onChange="clickable()"></td>
				<td class="left">呈报序号：</td>
				<td class="right"><input name="ReportNum" class="common" type="text" onChange="clickable()"></td>
				<td class="left">呈报状态：</td>
				<td class="right"><input name="ReportState" class="common" type="text" onChange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">呈报人：</td>
				<td  class="right"><input name="Reporter" class="common" type="text" onChange="clickable()"></td>
				<td  class="left">呈报机构：</td>
				<td  class="right">
					<input class="codecode" id="reportComCode" name="lcReport.reportComCode" class="common" type="text" value="" style="width:20%" ><input name="reportCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">呈报日期：</td>
				<td  class="right"><input name="ReportDate" class="common" type="text" onChange="clickable()"></td>
			</tr>
		</table>
		<table id="ReportDesc" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td >呈报描述</td>
			</tr>
			<tr>
				<td><textarea name="ReportDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td colspan="4">呈报处理意见(包括符号最多1000汉字)</td>
			</tr>
			<tr>
				<td><textarea name="ReportDeal" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "ClaimInfo" value="案件信息查看" onClick="self.location.href='${ctx}/claim/claimoperate/report/ReportAdd.jsp'" />
					<input type="button" class="cssbutton" name = "saveButton" value="保  存" onClick="" />
					<input type="button" class="cssbutton" name = "returnButton" value="返  回" onClick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>