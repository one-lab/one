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
    
	    <title>异地委托信息查询</title>
	    
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
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">赔案查询</td>
			</tr>
			<tr>
				<td class="left">赔案阶段：</td>
				<td class="right"><input class="codecode" id="claimPhase" name="lcReport.claimPhase" class="common" type="text" value="" style="width:20%"><input name="claimPhase" class="common" type="text" onchange="clickable()" style="width:68%" value=""></td>
				<td class="left">赔案号：</td>
				<td class="right"><input name="claimNo" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">管理机构：</td>
				<td class="right"><input class="codecode" id="mngCom" name="lcReport.mngCom" class="common" type="text" value="" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value=""></td>
				<td class="left">委托标志：</td>
				<td class="right"><input class="codecode" id="entrustFlag" name="lcReport.entrustFlag" class="common" type="text" value="" style="width:20%"><input name="entrustFlag" class="common" type="text" onchange="clickable()" style="width:68%" value=""></td>
				<td class="common"> </td>
				<td class="common"></td>
			</tr>
		</table>
		<table  id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AppntSelect" value="查  询" onClick="" />
					<input type="button" class="cssbutton" name = "AppntSelect" value="赔案明细查询" onclick="self.location.href='${ctx}/claim/claimoperate/register/PastClaimInfoQuery.jsp'" />
				</td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">赔案列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">立案号</td>
					<td width="10%">委托岗位</td>
					<td width="10%">委托日期</td>
					<td width="10%">委托操作员</td>
					<td width="15%">委托机构</td>
					<td width="10%">被委托岗位</td>
					<td width="15%">被委托机构</td>
					<td width="9%">委托标志</td>
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
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">备注信息录入</td>
			</tr>
		</table>
		<table  id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>备注信息</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">选择处理类型：</td>
				<td  class="right">
					<input class="codecode" id="dealCode" name="lcReport.dealCode" class="common" type="text" value="01" style="width:20%"><input name="dealType" class="common" type="text" onchange="clickable()" style="width:68%" value="接受委托"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="sureButton" value="处理确认" onClick="" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>