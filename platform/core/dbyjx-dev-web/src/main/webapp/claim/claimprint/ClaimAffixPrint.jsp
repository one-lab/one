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
    
	    <title>赔案单证综合打印</title>
	    
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
		<table id="ClaimPrintInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">打印信息</td>
			</tr>
			<tr>
				<td class="left">赔案号：</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onChange="clickable()"></td>
				<td class="left">出险人客户号：</td>
				<td class="right"><input name="AppNum" class="common" type="text" onChange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
			<tr>
				<td class="left" width="8%">单证代码：</td>
				<td class="right" width="20%" align="left">
					<input class="codecode" id="affixCodeCode" name="lcReport.affixCodeCode" class="common" type="text" value="CML003" style="width:20%"><input name="affixCode" class="common" type="text" onchange="clickable()" style="width:68%" value="赔款给付方式协议书">
				</td>
				<td class="common"></td>
				<td class="common"> </td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "printButton" value="打  印" onClick="" />
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
					
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>