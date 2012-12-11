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
    
	    <title>回退案件处理</title>
	    
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
		<table id="RollbackCaseInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">回退信息</td>
			</tr>
			<tr>
				<td class="left">赔案号：</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onChange="clickable()"></td>
				<td class="left">原审核结论：</td>
				<td class="right"><input name="OldAuditResult" class="common" type="text" onChange="clickable()"></td>
				<td class="left">原赔付总金额：</td>
				<td class="right"><input name=" OldTotalMount" class="common" type="text" onChange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">回退后审核结论：</td>
				<td  class="right">
					<input class="codecode" id="auditResultCode" name="lcReport.auditResultCode" class="common" type="text" value="" style="width:20%"><input name="auditResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">回退原因：</td>
				<td  class="right">
					<input class="codecode" id="rollReasonCode" name="lcReport.rollReasonCode" class="common" type="text" value="" style="width:20%"><input name="rollReason" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">回退申请日期：</td>
				<td  class="right"><input name="ApplyDate" class="common" type="text" onChange="clickable()"></td>
			</tr>
		</table>
		<table id="RollbackInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td >回退原因详细说明(包括符号最多900汉字)</td>
			</tr>
			<tr>
				<td><textarea name="RollbackReason" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td >备注(包括符号最多900汉字)</td>
			</tr>
			<tr>
				<td><textarea name="remarks" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "ClaimInfo" value="赔案明细查询" onClick="self.location.href='${ctx}/claim/rollbackdeal/RollbackClaimInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name = "saveButton" value="保  存" onClick="" />
					<input type="button" class="cssbutton" name = "TempPayVerify" value="暂交费核销" onClick="" />
					<input type="button" class="cssbutton" name = "Rollback" value="回退确认" onClick="" />
					<input type="button" class="cssbutton" name = "returnButton" value="返  回" onClick="javascript:history.back();" />
				</td>
			</tr>
		</table>
		<table id="RollbackAccountInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>待回销的应收信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%"></td>
					<td width="4%">序号</td>
					<td width="15%">通知书号码</td>
					<td width="15%">投保人客户号码</td>
					<td width="10%">总应收金额</td>
					<td width="20%">缴费日期</td>
					<td width="15%">银行转账成功标志</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "PrintButton" value="打印理赔回退收费通知书" onClick="" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>