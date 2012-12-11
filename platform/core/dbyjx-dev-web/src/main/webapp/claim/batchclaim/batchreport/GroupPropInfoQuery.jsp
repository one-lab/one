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
    
	    <title>团体保单号及单位名称查询</title>
	    
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
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">团体保单号及单位名称查询</td>
			</tr>
			<tr>
				<td class="left">投保单位名称：</td>
				<td class="right"><input name="appntComName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">团体保单号：</td>
				<td class="right"><input name="groupAppro" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人身份证号码：</td>
				<td class="right"><input name="AppntIDNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">出险人姓名：</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="common">
				<td class="common">
				<td class="common">
				<td class="common">
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "querycssbutton" value="查  询" onclick="" />
					<input type="button" class="cssbutton" name = "returnbutton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">团体保单号及单位名称列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="30%">团体报案号</td>
					<td width="24%">投保单位名称</td>
					<td width="15%">生效日期</td>
					<td width="25%">管理机构</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio" value="" /></td>
					<td>1</td>
					<td>S86012012018</td>
					<td>821200</td>
					<td>2012-05-01</td>
					<td>46521</td>
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
	</div>
	</form>
</body>
</html>