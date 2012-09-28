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
    	
	    <title>理赔类型</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">ctx = "${ctx}";</script>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>
<body>
	<div id="claimType" style="width:100%">
		<table id="claimType" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>理赔类型<img src="${ctx}/images/bgMarkMustInput.jpg" >&nbsp;&nbsp;
					<input type="checkbox" name="llReportReason[0].reasonCode" value="01" />身故
					<input type="checkbox" name="reasonCodeList[1].reasonCode" value="02" />重疾
					<input type="checkbox" name="reasonCodeList[2].reasonCode" value="03" />伤残
					<input type="checkbox" name="reasonCodeList[3].reasonCode" value="04" />津贴
					<input type="checkbox" name="reasonCodeList[4].reasonCode" value="05" />医疗
				</td>
			</tr>
			<tr>
				<td>事故描述(包括符号最多500汉字)</td>
			</tr>
			<tr>
				<td colspan="6" ><textarea id="accDesc" name="llSubReport.accDesc" cols="" rows="4" style="width:100%"><s:property value="#request.llSubReportList[0].accDesc" /></textarea></td>
			</tr>
		</table>
	</div>
</body>
</html>