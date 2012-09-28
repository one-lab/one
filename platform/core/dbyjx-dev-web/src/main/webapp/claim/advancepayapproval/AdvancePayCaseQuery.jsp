<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>"/>
    
	    <title>预付申请案件查询</title>
	    
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
		<meta http-equiv="description" content="This is my page"/>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>
<body>
	<form name="fm" method="post" onKeyPress="KeyDown()">
	<div style="width:100%">
		<table id="QueryCondition" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>请输入查询条件</td>
			</tr>
			<tr>
				<td class="left">赔案号：</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">出险人姓名：</td>
				<td class="right"><input name=" AppntName" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">出险人性别</td>
				<td class="right">
					<input class="codecode" id="appntCode" name="lcReport.appntCode" class="common" type="text" value="01" style="width:20%" ><input name="appntSex" class="common" type="text" onchange="clickable()" style="width:68%" value="男">
				</td>
			</tr>
			<tr>
				<td class="left">出险人证件类型：</td>
				<td class="right">
					<input class="codecode" id="appntIDCode" name="lcReport.appntIDCode" class="common" type="text" value="01" style="width:20%" ><input name="appntIDType" class="common" type="text" onchange="clickable()" style="width:68%" value="身份证">
				</td>
				<td class="left">出险人证件号码：</td>
				<td class="right"><input name="AppntIDNo" class="common" type="text" onChange="clickable()"/></td>
				<td class="common">  </td>
				<td class="common"> </td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="queryButton" value="查  询" onClick=""/></td>
			</tr>
		</table>
		<table id="ShareWorkPool" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>共享工作池</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">赔案号</td>
					<td width="15%">赔案状态</td>
					<td width="15%">出险人姓名</td>
					<td width="15%">出险人性别</td>
					<td width="15%">出险日期</td>
					<td width="15%">立案日期</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value=""/></td>
					<td>1</td>
					<td>S86012012018</td>
					<td>待审核</td>
					<td>马布</td>
					<td>男</td>
					<td>2012-05-01</td>
					<td>2012-05-15</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align="right"><input type="button" class="cssbutton" value="首  页"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="上一页"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="下一页"/></td>
				<td width="45%"><input type="button" class="cssbutton" value="尾  页"/></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="ApplyButton" value="申  请" onClick=""/></td>
			</tr>
		</table>
		<table id="PersonWorkPool" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>个人工作池</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">赔案号</td>
					<td width="15%">赔案状态</td>
					<td width="15%">出险人姓名</td>
					<td width="15%">出险人性别</td>
					<td width="15%">出险日期</td>
					<td width="15%">立案日期</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value=""/></td>
					<td>1</td>
					<td><a href="javascript:void(0)" onclick="self.location.href='${ctx}/claim/advancepayapproval/AdvancePayApproval.jsp'">S86012012018</a></td>
					<td>待审核</td>
					<td>马布</td>
					<td>男</td>
					<td>2012-05-01</td>
					<td>2012-05-15</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align="right"><input type="button" class="cssbutton" value="首  页"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="上一页"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="下一页"/></td>
				<td width="45%"><input type="button" class="cssbutton" value="尾  页"/></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>