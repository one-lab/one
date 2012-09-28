<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>契调录入页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">ctx = "${ctx}";</script>
<script src="common/js/SimpleCalendar.js"></script>
<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
<script type="text/javascript" src="${ctx}/prpall/group/report/js/ReportAudit.js"></script>

</head>

<body>
<form id="propallSearchForm" method="post" >
<div style="width: 100%">
<table id="ReportCompanyInfo" class="common" cellpadding="3"
	cellspacing="1">
	<tr>
		<td class="formtitle" colspan="6"><img
			src="images/bgformtitle.gif" style="cursor: hand;"> 契调基本信息</td>
	</tr>
	<tr>
		<td class="left">呈报件号：</td>
		<td class="right"><input name="propallSearchInfo.id.repNo" class="common" type="text" id="repNo" value='<s:property value="#request.lcReport.repNo"/>'></td>
		<td class="left">呈报人：</td>
		<td class="right"><input name="propallSearchInfo.repOperator" class="common"	type="text" id="repOperator" value='<s:property value="#request.lcReport.repOperator"/>'></td>
		<td class="left">单位全称：</td>
		<td class="right"><input name="propallSearchInfo.name" class="common" type="text" id="grpName" value='<s:property value="#request.lcReport.name"/>'></td>
	</tr>
	<tr>
		<td class="left">契调原因：</td>
		<td class="right"><input name="propallSearchInfo.reason" class="codecode" style="width:20%"	type="text" id="SearchReason" ondblclick="queryCode('SearchReason','PrpallSearchReasonName','PDLDcode1','codeType:PrpallSearchReason');"><input id='PrpallSearchReasonName' name="PrpallSearchReasonName" class="common" type="text" style="width:68%" ><img src="${ctx }/images/bgMarkMustInput.jpg"></td>
		<td class="left">调查人：</td>
		<td class="right"><input name="propallSearchInfo.investor" class="common"	type="text" id="SearchPeople"><img	src="${ctx }/images/bgMarkMustInput.jpg"></td>
		<td class="left"></td>
		<td class="right"></td>
	</tr>
</table>
<table id="PrpallSearchInfo" class="common" cellpadding="3"
	cellspacing="1" width="50%">
	<thead>
		<tr>
			<td class="formtitle" colspan="6"><img
				src="images/bgformtitle.gif" style="cursor: hand;"> 契调项目录入</td>
		</tr>
		<tr class="tableHead">
			<td width="5%" align="left">序号</td>
			<td width="20%" align="left">契调项目编号</td>
			<td width="65%" align="left">契调项目名称</td>
			<td width="10%" align="left">&nbsp;</td>
		</tr>
	</thead>
	<tbody id="PrpallSearchInfoBody">
	</tbody>
	<tr>
	<td><input type='button' value="+" onclick="addItem()"/></td>
	</tr>
	<tr>
		<td colspan="6">其他契调信息</td>
	</tr>
	<tr>
		<td colspan="4"><textarea name="propallSearchInfo.otherMessage" cols="100%" rows="5"
			id="otherInfo"></textarea></td>
	</tr>
</table>
<s:debug></s:debug>
<table>
	<tr>
		<td colspan="6"><input type="button" name="returnButton"
			class="cssbutton" value="确  认" onclick="reportConCommit()"> <input
			type="button" name="returnButton" class="cssbutton" value="返  回"
			onclick="javascript:history.go(-1);"></td>
	</tr>
</table>
</div>
</form>
</body>
</html>
