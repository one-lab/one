<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>"/>
    
	    <title>定点医院考核</title>
	    
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
		<meta http-equiv="description" content="This is my page"/>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css"/>
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>
<body>
	<form name="fm" method="post" onKeyPress="KeyDown()">
	<div style="width:100%">
		<table id="HospitalInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>医院考核</td>
			</tr>
			<tr>
				<td class="left">医院名称：</td>
				<td class="right"><input name="HosName" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">医院等级：</td>
				<td class="right"><input name="HosClass" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id="HosInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="50%">评估项目名称</td>
					<td width="20%">分数</td>
					<td width="20%">评估分数</td>
				</tr>
			</thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">分数合计：</td>
				<td class="right"><input name="TotalFraction" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AddButton" value="保  存" onClick=""/>
					<input type="button" class="cssbutton" name="ModifyButton" value="修  改" onClick=""/>
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
					<input type="button" class="cssbutton" name="HosAssessTab" value="医院评估标准表" onClick=""/>
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>