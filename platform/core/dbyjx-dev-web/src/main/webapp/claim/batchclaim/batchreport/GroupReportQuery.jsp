<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>">
    
	    <title>团体报案查询</title>
	    
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
	<div style="width:100%">
		<table id="QueryReportInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">报案信息查询</td>
			</tr>
			<tr>
				<td class="left">团体报案号：</td>
				<td class="right"><input name="reportNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">团体保单号：</td>
				<td class="right"><input name="reportName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人姓名：</td>
				<td class="right"><input name=" AppntName" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "queryButton" value="查  询" onclick="" />
				</td>
			</tr>
		</table>
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">团体报案号</td>
					<td width="15%">报案人姓名</td>
					<td width="12%">报案日期</td>
					<td width="16%">团体单位名称</td>
					<td width="12%">出险日期</td>
					<td width="12%">出险人数</td>
					<td width="12%">报案状态</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio" value="" /></td>
					<td>1</td>
					<td><a href="javascript:void(0)" onclick="self.location.href='${ctx}/claim/batchclaim/batchreport/GroupReportAdd.jsp'">S86012012018</a></td>
					<td>马布</td>
					<td>2012-05-01</td>
					<td>46521</td>
					<td>2012-03-01</td>
					<td>3</td>
					<td>已完成</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<br />
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "addNewReport" value="新增报案" onClick="self.location.href='${ctx}/claim/batchclaim/batchreport/GroupReportAdd.jsp'" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>