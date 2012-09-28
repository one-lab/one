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
    
	    <title>调查过程信息查看</title>
	    
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
		<table id="SurveyFeeList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">该赔案的所有调查费用列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">赔案号</td>
					<td width="15%">调查序号</td>
					<td width="12%">调查机构</td>
					<td width="10%">费用类型</td>
					<td width="12%">发生时间</td>
					<td width="10%">费用金额</td>
					<td width="10%">领款人</td>
					<td width="10%">操作人</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="5%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="85%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<table id="SurveyFeeInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">查看调查费用详细信息</td>
			</tr>
			<tr>
				<td  class="left">赔案号：</td>
				<td  class="right"><input name="claimNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">调查序号：</td>
				<td  class="right">
					<input name="surveyNum" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">调查机构：</td>
				<td  class="right">
					<input class="codecode" id="surveyCom" name="lcReport.surveyCom" class="common" type="text" value="210026" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司">
				</td>
			</tr>
			<tr>
				<td  class="left">费用类型：</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">费用金额：</td>
				<td  class="right"><input name="FeeMount" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">发生时间：</td>
				<td  class="right">
					<input name="HappDate" id="HappDate" class="common" type="text" onchange="clickable()" />
				</td>
			</tr>
			<tr>
				<td  class="left">领款人：</td>
				<td  class="right"><input name="payee" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">领款方式：</td>
				<td  class="right">
					<input class="codecode" id="receTypeCode" name="lcReport.receTypeCode" class="common" type="text" value="" style="width:20%"><input name="receType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="RemarksContent" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td colspan="6">备注 </td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="remarkContent" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" /></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>