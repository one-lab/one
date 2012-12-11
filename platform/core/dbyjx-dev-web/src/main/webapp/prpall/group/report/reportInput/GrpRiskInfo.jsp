<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>集体险种信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/report/js/ReportAdd.js"></script>
  </head>
  
  <div style="width: 100%">
<table id="GrpPolInfor" class="common" cellpadding="3" cellspacing="0">
	<thead>
		<tr>
			<td class="formtitle" colspan="6"><img
				src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">
			集体保单险种信息</td>
		</tr>
		<tr class="tableHead">
			<td width="3%">&nbsp;</td>
			<td width="7%">序号</td>
			<td width="15%">险种编码</td>
			<td width="15%">险种名称</td>
			<td width="15%">保费</td>
			<td width="15%">保额</td>
			<td width="15%">费用率</td>
		</tr>
	</thead>
	<tbody id="riskContent">
	</tbody>
</table>
</div>
<!-- 选择附加险的时候显示主险编码 -->
<div style="width: 100%">
<table id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
	<tr>
		<td class="formtitle" colspan="4"><img
			src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">险种信息</td>
	</tr>
	<tr>
		<td width="17%" class="left">险种编码：</td>
		<td width="33%" class="right"><input id="riskCode"
			class="codecode" name="riskCode" type="text" style="width: 20%"
			value="GCAA"
			ondblclick="queryCode('riskCode','riskName','findRisk','')" /><input
			id="riskName" name="RiskName" class="common" type="text"
			style="width: 68%" value="都邦建设工程团体附加意外伤害保险" /></td>
		<td id="mainRiskNameTD" style="display: none" width="17%" class="left">主险编码：</td>
		<td id="mainRiskValueTD" style="display: none" width="33%"
			class="right"><input id="mainRiskCode" class="codecode"
			name="RiskCode" class="common" type="text" style="width: 20%"
			value="GCAA"
			ondblclick="queryCode('mainRiskCode','mainRiskName','findRelationRisk','rr_id_relaRiskCode:riskCode')" /><input
			id="mainRiskName" name="RiskName" class="common" type="text"
			style="width: 68%" value="都邦建设工程团体意外伤害保险A款" /></td>
		<td width="18%" class="left">费用率（0-1）：</td>
		<td width="32%" class="right"><input id="payMode" name="PayMode"
			class="common" type="text" /></td>
	</tr>
</table>
</div>
<div style="width: 100%">
<table>
	<tr>
		<td colspan="4"><input type="button" class="cssbutton"
			name="AddRisk" value="添加险种" onclick="addRisk();"> <input
			type="button" class="cssbutton" name="DelRisk" value="删除险种"
			onclick="deleteRisk()"></td>
	</tr>
</table>
<hr />
<table>
	<tr>
		<td colspan="6">
			<input type="button" class="cssbutton" name="AddPlan" value="保障计划定制" onclick="opentEnsure()" >
			<input type="button" class="cssbutton" name="InsuredImport" value="被保人清单导入" onclick="location.href='${ctx}/prpall/group/report/reportInput/InsuredListImport.jsp'">
		</td>
	</tr>
</table>
<hr>
</div>
</html>