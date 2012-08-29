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
    
    <title>报案信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx }/claim/claimoperate/report/js/ReportInfo.js"></script>
	
  </head>
  
  <body>
  <div id="reportInfo" style="width:100%">
	<table id="ReportInfoEntry" class="common" cellpadding="3" cellspacing="1">
		<tr>
			<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">报案信息</td>
		</tr>
		<tr>
			<td class="left">事件号：</td>
			<td class="right"><input id="accNo" name="llAccident.accNo" class="common" type="text" value='<s:property value="#request.llAccidentList[0].accNo" />' /></td>
			<td class="left">报案号：</td>
			<td class="right"><input id="rptNo" name="llReport.rptNo" class="common" type="text" value='<s:property value="#request.llReport.rptNo" />' /></td>
			<td class="left">出险人查询：</td>
			<td class="right">
				<input type="button" class="cssButton" name="appntQuery" value="出现人查询" onclick="findAppnt();">
			</td>
		</tr>
		<tr>
			<td  class="left">报案人与出险人关系：</td>
			<td  class="right">
				<input class="codecode" id="relation" name="llReport.relation" type="text" style="width:20%" value='<s:property value="#request.llReport.relation" />' ondblclick="queryCode('relation','relationValue','PDLDcode1','codeType:Relation')" /><input id="relationValue" name="llReport.relationValue" class="common" type="text" style="width:68%" value='<s:property value="#request.llReport.relationValue" />' />
			</td>
			<td  class="left">报案日期：</td>
			<td class="right">
				<input id="rptDate" name="llReport.rptDate" class="common" type="text" style="width: 73%" value="<s:date name="#request.llReport.rptDate" format="yyyy-MM-dd"/>" /><img style='cursor: hand' 
					   align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'rptDate',rptDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
			</td>
			<td  class="left">报案人姓名：</td>
			<td  class="right"><input id="rptorName" name="llReport.rptorName" onclick="checkValue();" class="common" type="text" value='<s:property value="#request.llReport.rptorName" />' /><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
		</tr>
		<tr>
			<td  class="left">报案人电话：</td>
			<td  class="right"><input id="rptorPhone" name="llReport.rptorPhone" class="common" type="text" value='<s:property value="#request.llReport.rptorPhone" />' /></td>
		
			<td  class="left">报案人地址：</td>
			<td  class="right"><input id="rptorAddress" name="llReport.rptorAddress" class="common" type="text" value='<s:property value="#request.llReport.rptorAddress" />' /></td>
			<td  class="left">报案人邮编：</td>
			<td  class="right"><input id="email" name="llReport.postCode" class="common" type="text" value='<s:property value="#request.llReport.postCode" />' /></td>
		</tr>
		<tr>
			<td  class="left">报案方式：</td>
			<td  class="right">
				<input class="codecode" id="rptMode" name="llReport.rptMode" type="text" style="width:20%" value='<s:property value="#request.llReport.rptMode" />' ondblclick="queryCode('rptMode','rptModeValue','PDLDcode1','codeType:RptMode')" /><input id="rptModeValue" name="llReport.rptModeValue" class="common" type="text" style="width:68%" value='<s:property value="#request.llReport.rptModeValue" />' />
			</td>
			<td  class="left">管辖机构：</td>
			<td class="right">
				<input type="hidden" id="upperComCode" value='<s:property value="#session.prpDcompany.comCode"/>' />
				<input id="comCode" name="llReport.mngCom" class="codecode" type="text" style="width: 20%" ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" value='<s:if test="#request.conditonCom==null" ><s:property value="#session.prpDcompany.comCode"/></s:if><s:else><s:property value="#request.llReport.mngCom"/></s:else>'><input id="comName" name="llReport.mngComName" class="common" type="text" style="width: 68%" value='<s:property value="#request.llReport.mngComName"/>' /><img src="${ctx}/images/bgMarkMustInput.jpg"></td>
			<td  class="left">报案受理人：</td>
			<td  class="right"><input id="operator" name="llReport.operator" class="common" type="text" value='<s:property value="#request.llReport.operator" />' /></td>
		</tr>
		<tr>
			<td  class="left">申请类型：</td>
			<td  class="right">
				<input class="codecode" id="rgtClass" name="llReport.rgtClass" type="text" style="width:20%" value='<s:property value="#request.llReport.rgtClass" />' ondblclick="queryCode('rgtClass','rgtClassValue','PDLDcode1','codeType:RgtClass')" /><input id="rgtClassValue" name="llReport.rgtClassValue" class="common" type="text" style="width:68%" value='<s:property value="#request.llReport.rgtClassValue" />' />
			</td>
			<td class="common"> </td>
			<td class="common"> </td>
			<td class="common"> </td>
			<td class="common"> </td>
		</tr>
	</table>
  </div>
  </body>
</html>