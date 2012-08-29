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
    
	    <title>报案查询</title>
	    
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
		<table id="ClaimQuery" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>赔案查询</td>
			</tr>
			<tr>
				<td class="left">赔案阶段：</td>
				<td class="right">
					<input class="codecode" id="claimStageCode" name="lcReport.claimStageCode" class="common" type="text" value="" style="width:20%" ><input name="claimStage" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">赔案号：</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">操作员代码：</td>
				<td class="right"><input name="OperCode" class="common" type="text" onChange="clickable()"/></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="queryButton" value="查  询" onClick=""/></td>
			</tr>
		</table>
		<table id="ClaimInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>赔案列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%"></td>
					<td width="4%">序号</td>
					<td width="20%">赔案号</td>
					<td width="17%">出险人姓名</td>
					<td width="20%">出险日期</td>
					<td width="20%">当前操作员代码</td>
					<td width="17%">当前操作员姓名</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align="right"><input type="button" class="cssbutton" value="首  页"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="上一页"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="下一页"/></td>
				<td width="45%"><input type="button" class="cssbutton" value="尾  页"/></td>
			</tr>
		</table>
		<table id="OldInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">原操作员：</td>
				<td class="right"><input name="OldOperator" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">指定操作员：</td>
				<td class="right">
					<input class="codecode" id="appointOperCode" name="lcReport.appointOperCode" class="common" type="text" value="" style="width:20%" ><input name="appointOper" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="AppointButton" value="指定确认" onClick=""/></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>