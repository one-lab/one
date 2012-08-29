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
    
	    <title>处理二核</title>
	    
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
					<td width="2%"><input type="radio" name="Redio" value="" /></td>
					<td width="4%">序号</td>
					<td width="25%">赔案号</td>
					<td width="25%">合同号码</td>
					<td width="22%">发起二核日期</td>
					<td width="22%">出险人姓名</td>
				</tr>
			</thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">提交二核原因</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="ContractInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="5"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已经二次核保完成的合同列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="32%">赔案号</td>
					<td width="32%">合同号码</td>
					<td width="30%">发起二核日期</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>414512140011</td>
					<td>421354111154</td>
					<td>2010-12-01</td>
				</tr>
				<tr class="content">
					<td><input type="radio" name="Redio2" value="" /></td>
					<td>1</td>
					<td>414512140011</td>
					<td>421354111154</td>
					<td>2010-12-01</td>
				</tr>
			</tbody>
		</table>
		<table id="TypePlan" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种计划</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="10%">险种代码</td>
					<td width="15%">险种名称</td>
					<td width="10%">保额(元)</td>
					<td width="10%">份数/档次</td>
					<td width="6%">交费年期</td>
					<td width="10%">标准保费(元)</td>
					<td width="10%">原保费(元)</td>
					<td width="10%">加费金额</td>
					<td width="15%">原核保决定</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>0612</td>
					<td>都邦附加个人意外伤害医疗保险</td>
					<td>2000</td>
					<td>10</td>
					<td>1</td>
					<td>1000</td>
					<td>1000</td>
					<td>0</td>
					<td>标准体</td>
				</tr>
				<tr class="content">
					<td>2</td>
					<td>0612</td>
					<td>都邦附加个人意外伤害医疗保险</td>
					<td>2000</td>
					<td>10</td>
					<td>1</td>
					<td>1000</td>
					<td>1000</td>
					<td>0</td>
					<td>标准体</td>
				</tr>
			</tbody>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">核保意见</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="Button" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>