<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.*"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>呈报审核</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${ctx}/common/css/Standard.css" rel="stylesheet"
	type="text/css" />
	<script type="text/javascript"> var ctx="${ctx}";</script>
<script src="${ctx}/common/calender/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
<script type="text/javascript" src="${ctx}/prpall/group/report/js/ReportAudit.js"></script>
<script type="text/javascript">
$(function(){
	initialReportAudit();
});
</script>
</head>
<body>
<form name="fm" method="post" id="reportForm">
<div style="width: 100%">
<table id="ReportComAppInfo" class="common" cellpadding="3"
	cellspacing="0">
	<tr>
		<td class="left">呈报申请号：</td>
		<td class="right"><input name="lcReport.repNo" class="common"
			type="text" id="repNo"></td>
		<td class="left">呈报人：</td>
		<td class="right"><input name="lcReport.repOperator" class="common"
			type="text" id="repOperator"></td>
		<td class="left">投保单位全称：</td>
		<td class="right"><input name="lcReport.name" class="common"
			type="text" id="name"></td>
	</tr>
	<tr>
		<td class="left">呈报机构：</td>
		<td class="right">
		<input type="hidden" id ="upperComCode" value='<s:property value="#session.prpDcompany.comCode"/>'/>
		<input id="manageCom" name="lcReport.manageCom" class="codecode" type="text" ondblclick="queryCode('manageCom','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" style="width:20%"  value='<s:if test="#request.conditonCom==null" ><s:property value="#session.prpDcompany.comCode"/></s:if><s:else><s:property value="#request.conditonCom"/></s:else>'>
					<input id='comName' name="comName" class="common" type="text" style="width:68%" value='<s:property value="#session.prpDcompany.comCName"/>' >
					<img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
		<td class="left">呈报日期：</td>
		<td class="right"><input name="lcReport.repApplyDate" id="reportDate"
			class="common" type="text" style="width: 73%" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>">
		<img style='cursor: hand' align="middle"
			src="${ctx}/images/bgcalendar.gif"
			onClick="WdatePicker({el:'ReportDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
		</td>
		<td class="left"></td>
		<td class="right"></td>
	</tr>
	</table>
	<table id="QueryApplyInfo" class="common" cellpadding="3"
	cellspacing="0">
	<tr>
		<td><input type="button" class="cssbutton" name="QueryButton"
			value="查  询" onClick="findReportAudit()"></td>
	</tr>
	</table>
	<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
	<thead>
		<tr>
			<td class="formtitle" colspan="6"><img
				src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">共享工作池</td>
		</tr>
		<tr class="tableHead">
			<td width="3%">&nbsp;</td>
			<td width="5%">序号</td>
			<td width="12%">呈报申请号</td>
			<td width="12%">呈报人</td>
			<td width="12%">呈报机构</td>
			<td width="14%">呈报日期</td>
			<td width="18%">投保单位全称</td>
			<td width="12%">核保师</td>
			<td width="12%">状态</td>
		</tr>
	</thead>
	<tbody id="PublicContent">
	</tbody>
	<div>
	<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
		<tr>
			<td width="45%" align='right'><input type="button"
				class="cssbutton" value="首  页"
				onclick="location.href='ReportAuditDeal.jsp'"></td>
			<td width="5%"><input type="button" class="cssbutton"
				value="上一页"></td>
			<td width="5%"><input type="button" class="cssbutton"
				value="下一页"></td>
			<td width="45%"><input type="button" class="cssbutton"
				value="尾  页"></td>
		</tr>
	</table>
	</div>
	</table>
	<table id="ApplyInfo" class="common" cellpadding="3" cellspacing="0">
		<tr>
		<td><input type="button" name="RepQueryButton" class="cssbutton"
			value="呈报件查看"
			onclick="location.href = '/prpall/group/report/reportInput/ReportAdd.jsp'"> <input
			type="button" name="ApplyButton" class="cssbutton" value="申  请"
			onclick="applyReportAduit()"></td>
	</tr>
	</table>
	<br>
	<table id="PrivateInfo" class="common" cellpadding="3" cellspacing="0">
	<thead>
		<tr>
			<td class="formtitle" colspan="6"><img
				src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">
			个人工作池</td>
		</tr>
		<tr class="tableHead">
			<td width="3%">&nbsp;</td>
			<td width="5%">序号</td>
			<td width="12%">呈报申请号</td>
			<td width="12%">呈报人</td>
			<td width="12%">呈报机构</td>
			<td width="14%">呈报日期</td>
			<td width="18%">投保单位全称</td>
		</tr>
	</thead>
	<tbody id="PrivateContent">
	</tbody>
	</table>
	
	<div>
	<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
		<tr>
			<td width="45%" align='right'><input type="button"
				class="cssbutton" value="首  页"></td>
			<td width="5%"><input type="button" class="cssbutton"
				value="上一页"></td>
			<td width="5%"><input type="button" class="cssbutton"
				value="下一页"></td>
			<td width="45%"><input type="button" class="cssbutton"
				value="尾  页"></td>
		</tr>
	</table>
	</div>
	<table>
		<tr>
			<td><input type="button" value="开始审核" onclick="applyReportView()"/></td>
		</tr>
	</table>

</div>
</form>
</body>
</html>
