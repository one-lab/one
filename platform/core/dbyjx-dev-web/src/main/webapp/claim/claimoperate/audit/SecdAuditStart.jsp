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
    
	    <title>审核信息查询</title>
	    
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
		<table id="ContractInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">该被保人下的所有合同</td>
				</tr>
				<tr class="tableHead">
					<td width="2%"><input type="checkbox" name="CheckBox" value="" disabled/></td>
					<td width="4%">序号</td>
					<td width="20%">合同号</td>
					<td width="20%">投保人客户号码</td>
					<td width="20%">投保人名称</td>
					<td width="20%">管理机构</td>
					<td width="14%">赔案相关标志</td>
				</tr>
		    </thead>
		    <tbody>
				<tr class="content">
					<td><input type="checkbox" name="CheckBox" value="" /></td>
					<td>1</td>
					<td>1424594905</td>
					<td>1641344124</td>
					<td>马布</td>
					<td>862100</td>
					<td>1-不相关</td>
				</tr>
			</tbody>
		</table>
		<hr />
		<table id="RegisterInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">发送二核原因：</td>
				<td class="right">
					<input class="codecode" id="secdauditCode" name="lcReport.secdauditCode" class="common" type="text" value="" style="width:20%"><input name="secdauditReason" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
			<tr>
				<td colspan="2">具体原因录入(包括符号最多500汉字)</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="PropQuery" value="保单查询" onClick="self.location.href='${ctx}/claim/claimoperate/audit/ProposalInfo.jsp'" />
					<input type="button" class="cssbutton" name="EdorInfo" value="保全明细" onclick="self.location.href='${ctx}/claim/claimoperate/audit/IndEdorInfo.jsp'" />
					<input type="button" class="cssbutton" name="sureButton" value="确  认" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>