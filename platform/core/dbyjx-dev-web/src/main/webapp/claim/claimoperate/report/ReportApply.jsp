<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>">
    
	    <title>发起呈报</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/claim/claimoperate/report/js/ReportApply.js"></script>

	</head>
<body>
	<form id="submitApplyFm" name="fm" method="post">
	<div style="width:100%">
		<input type="hidden" id="clmNo" name="llSubmitApply.id.clmNo" value='<s:property value="#parameters['llReport.rptNo']"/>' > 
		<table id="ReportInfo" class="common" cellpadding="3" cellspacing="1" >
			<tr>
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">发起呈报信息</td>
			</tr>
			<tr>
				<td class="left">出险人客户号：</td>
				<td class="right"><input id="customerNo" name="llSubmitApply.customerNo" class="common" type="text" value='<s:property value="#parameters['llSubReport.id.customerNo']"/>' ></td>
				<td class="left">出险人姓名：</td>
				<td class="right"><input id="customerName" name="llSubmitApply.customerName" class="common" type="text" value='<s:property value="#parameters['llSubReport.customerName']"/>' ></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id="ReportContent" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>呈报描述(包括符号最多500汉字)</td>
			</tr>
			<tr>
				<td  colspan="4"><textarea id="subDesc" name="llSubmitApply.subDesc" cols="100%" rows="5" style="witdh:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "saveButton" value="保  存" onClick="submitApply();" />
					<input type="button" class="cssbutton" name = "returnButton" value="返  回" onClick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>