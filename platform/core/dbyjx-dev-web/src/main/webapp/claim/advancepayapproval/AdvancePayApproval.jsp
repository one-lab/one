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
    
	    <title>预付签批录入</title>
	    
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
		
		<table id="GuarantItemInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>给付保项信息列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">赔案号</td>
					<td width="15%">保单号</td>
					<td width="10%">责任编码</td>
					<td width="10%">给付责任类型</td>
					<td width="10%">给付责任编码</td>
					<td width="10%">核赔赔付金额</td>
					<td width="10%">总预付金额</td>
					<td width="10%">出险客户姓名</td>
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
		<hr />
		<table id="AdvancePayDeal" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>保项的预付金额的处理</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">赔案号</td>
					<td width="15%">保单号</td>
					<td width="15%">责任编码</td>
					<td width="15%">给付责任类型</td>
					<td width="15%">本次预付金额</td>
					<td width="15%">预付日期</td>
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
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">输入预付金额：</td>
				<td class="right"><input name="PayMount" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td><input type="button" class="cssbutton" name="modifyButton" value="修  改" onClick=""/></td>
			</tr>
		</table>
		<hr />
		<table id="AdvancePayReason" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>预付原因录入</td>
			</tr>
			<tr>
				<td colspan="4">预付原因</td>
			</tr>
			<tr>
				<td><textarea name="AdvancePayReason" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>总公司意见录入</td>
			</tr>
			<tr>
				<td colspan="4">总公司意见</td>
			</tr>
			<tr>
				<td><textarea name="accidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "ClaimInfo" value="受益人分配" onClick="self.location.href='${ctx}/claim/claimoperate/audit/BnfDistbInfo.jsp'" />
					<input type="button" class="cssbutton" name = "saveButton" value="签批确认" onClick="" />
					<input type="button" class="cssbutton" name = "returnButton" value="返  回" onClick="javascript:history.back();" />
					<input type="button" class="cssbutton" name = "saveButton" value="影像查询" onClick="" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>