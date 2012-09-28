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
    
	    <title>理赔二次核保</title>
	    
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
		<table id="ContractList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">发起二核但未核保完成的合同列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="25%">赔案号</td>
					<td width="20%">核保人</td>
					<td width="25%">发起二核日期</td>
					<td width="20%">出险人姓名</td>
				</tr>
		    </thead>
		</table>
		<hr />
		<table id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AppntInfo" value="保单详细信息查询" onClick="self.location.href='${ctx}/claim/claimsecdapprove/AppInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name = "AuditResult" value="核保结论查询" onClick="" />
					<input type="button" class="cssbutton" name = "scanQuery" value="影像资料查询" onClick="" />
					<input type="button" class="cssbutton" name = "PhyExamQuery" value="体检资料查询" onClick="self.location.href='${ctx}/claim/claimsecdapprove/PhyExamInfoQuery.jsp'" />
				</td>
			</tr>
		</table>
		<table id="InsurancePlan" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种计划</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="10%">险种代码</td>
					<td width="10%">险种名称</td>
					<td width="10%">保额(元)</td>
					<td width="6%">份数/档次</td>
					<td width="6%">缴费年期</td>
					<td width="10%">标准保费(元)</td>
					<td width="10%">原保费(元)</td>
					<td width="10%">加费金额</td>
					<td width="10%">原核保决定</td>
				</tr>
		    </thead>
		</table>
		<table id="AuditOpinion" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td >核保意见(包括符号最多120汉字)</td>
			</tr>
			<tr>
				<td><textarea name="AuditOpinion" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AuditSucs" value="核保完成" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>