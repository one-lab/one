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
    
	    <title>保单查询清单</title>
	    
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
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="11"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">保单查询清单</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">集体合同号码</td>
					<td width="15%">合同号码</td>
					<td width="10%">管理机构</td>
					<td width="10%">生效日期</td>
					<td width="10%">交至日期</td>
					<td width="10%">签单机构</td>
					<td width="8%">保单类型</td>
					<td width="8%">保单状态</td>
					<td width="8%">到账日期</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>54321464121</td>
					<td>545812148</td>
					<td>北京支公司</td>
					<td>2012-03-01</td>
					<td>2012-03-01</td>
					<td>1986-03-01</td>
					<td>团单</td>
					<td>承保</td>
					<td>2012-03-01</td>
				</tr>
			</tbody>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="PolicyDetail" value="保单详细" onClick="self.location.href='${ctx}/claim/claimoperate/register/PolicyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>