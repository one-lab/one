<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.*"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>产品申请与查询页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/common/js/DateFormat.js"></script>
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/product/pddefine/baseinfodefine/js/pdbasedefine.js"></script>
	<script type="text/javascript">ctx= "${ctx}";</script>
  </head>
  <body>
  <div style = "width:60%" id="queryFormDiv">
    <form id="frmInput" name="frmInput" >
		<table id="QueryApplingRiskInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="4">
					<img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">请输入产品险种代码
				</td>
			</tr>
			<tr>
				<td class="left">产品险种代码：</td>
				<td class="right"><input name="pdLMRisk.riskCode" id="riskCode" class="common" type="text" value='<s:property value="riskCode"/>'></td>
				<td class="left">申请日期：</td>
				<td class="right">
					<input name="pdLMRisk.makeDate" id="makeDate" class="common" type="text"  style="width: 73%" value='<s:if test="makeDate==null"><%= new SimpleDateFormat("yyyy-MM-dd").format(new Date())%></s:if><s:else><s:date name="makeDate" format="yyyy-MM-dd"/></s:else>'/>
					<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'makeDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
					<input type="hidden" id = "comCode" name="comCode" value='<s:property value="#session.comCode"/>' />
				</td>				
			</tr>
		</table>
		<table id="QueryApplingRiskInfoButton" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="queryApplingRisk();" >
					<input type = "button" class="cssbutton" name="applyButton" value="申  请" onclick="return addRiskCode();">
					<input type="hidden" name="pageNo" id="pageNo" value="${pageNo==null ? 1 : pageNo}" /> 
                    <input type="hidden" name="pageSize" value="${pageSize==null ? 20 : pageSize}" >
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div id="listDiv">
	    <table id="ApplingRiskInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">定义中的产品</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="15%">产品险种代码</td>
					<td width="40%">产品险种名称</td>
					<td width="16%">申请日期</td>
					<td width="20%">申请人</td>
				</tr>
			</thead>
			<tbody id = "ApplingRiskDetail">
			  <s:iterator value="page.result" var="temp" status="index">
			  <tr class="content">
				<td width="4%"><input type='radio' name='selectApplingRadio' value='<s:property value="#temp.riskCode" />' /></td>
				<td width="5%"><s:property value="#index.count"/></td>
				<td width="15%"><s:property value="#temp.riskCode" /></td>
				<td width="40%"><s:property value="#temp.riskName" /></td>
				<td width="16%"><s:date name="#temp.makeDate" format="yyyy-MM-dd"/></td>
				<td width="20%"><s:property value="#temp.operator" /></td>
			  </tr>	
			  </s:iterator>			
			</tbody>
		</table>
	 
		<div id="pageDiv" align="right">
			<jsp:include page="/common/pub/page.jsp"></jsp:include>
		</div>	

		<input type = "button" class="cssbutton" name="defineButton" value="开始定义" onclick="queryModifyApplingRisk();">
	</div>
  </body>
  </html>
