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
    
	    <title>呈报处理查询</title>
	    
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
				<td class="left">报案号：</td>
				<td class="right"><input name="reportNum" class="common" type="text" onChange="clickable()"></td>
				<td class="left">出险人姓名：</td>
				<td class="right"><input name=" AppntName" class="common" type="text" onChange="clickable()"></td>
				<td class="left">呈报操作员：</td>
				<td class="right"><input name=" ReportOperator" class="common" type="text" onChange="clickable()"></td>
			</tr>
		</table>
		<table id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "queryButton" value="查  询" onClick="" />
				</td>
			</tr>
		</table>
		<table id="ReportList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">呈报公共队列</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="25%">报案号</td>
					<td width="20%">呈报序号</td>
					<td width="15%">已呈报次数</td>
					<td width="15%">出险人姓名</td>
					<td width="15%">任务操作员</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name = "applyButton" value="申  请" onClick="self.location.href='${ctx}/claim/reportdeal/ReportDeal.jsp'" /></td>
			</tr>
		</table>
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">呈报个人队列</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="25%">报案号</td>
					<td width="20%">呈报序号</td>
					<td width="15%">已呈报次数</td>
					<td width="15%">出险人姓名</td>
					<td width="15%">任务操作员</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>