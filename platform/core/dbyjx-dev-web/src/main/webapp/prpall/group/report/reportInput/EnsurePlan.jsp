<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>保险计划录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">var ctx="${ctx}";</script>
	<link href="${ctx }/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx }/common/js/SimpleCalendar.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/report/js/EnsurePlan.js"></script>
  </head>
  
  <body>
    <form id="planForm" name="fm">
	<div style = "width:100%">
		<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"> <img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     呈保单位信息</td>
			</tr>
			<tr>				
				<td  class="left">呈报申请号：</td>
				<td  class="right"><input id="repNo" name="lcContPlanReport.id.repNo" class="common" type="text" value='<s:property value="lcGrpContReport.id.repNo"/>' /></td>
				<td  class="left">管理机构：</td>
				<td  class="right"><input name="lcGrpContReport.manageCom" class="common" type="text" value='<s:property value="lcGrpContReport.manageCom"/>' /></td>
				<td  class="left">投保单位全称：</td>
				<td  class="right"><input name="lcGrpContReport.grpName" class="common" type="text" value='<s:property value="lcGrpContReport.grpName"/>' /></td>
			</tr>
		</table>
		<input type="text" id="grpContNo" name="lcContPlanReport.id.grpContNo" value='<s:property value="lcGrpContReport.id.grpContNo"/>' />
		<input type="text" id="proposalGrpContNo" name="lcContPlanReport.proposalGrpContNo" value='<s:property value="lcGrpContReport.proposalGrpContNo"/>' />
		<table id="AlivePlanInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     已存在保障计划</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="32%">保障计划编码</td>
					<td width="30%">保障计划名称</td>
					<td width="30%">该保障计划被保险人总数</td>
				</tr>
			</thead>
			<tbody id="AlivePlanInfoBody">
				<s:if test="lcContPlanReportList!=null">
					<s:iterator value="lcContPlanReportList" var="lcContPlanReport" status="s">
						<tr class="content">
							<td width="3%"><input type="radio" name="lcContPlanRadio" value=""/></td>
							<td width="5%"><s:property value="#s.count"/></td>
							<td width="32%"><s:property value="#lcContPlanReport.id.contPlanCode"/></td>
							<td width="30%"><s:property value="#lcContPlanReport.contPlanName"/></td>
							<td width="30%"><s:property value="#lcContPlanReport.peoples3"/></td>
						</tr>
					</s:iterator>
				</s:if>					
			</tbody>
		</table>
		
		<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保障计划定制</td>
			</tr>
			<tr>
				<td  class="left">保障计划编码：</td>
				<td  class="right"><input id="contPlanCode" class="common" name="lcContPlanReport.id.contPlanCode" type="text"  ></td>
				<td  class="left">保障计划名称：</td>
				<td  class="right"><input id="contPlanName" name="lcContPlanReport.contPlanName" class="common" type="text" ></td>
				<td  class="left">该保障计划被保险人总数：</td>
				<td  class="right"><input name="lcContPlanReport.peoples3" class="common" type="text" ></td>
			</tr>
		</table>
		<br />
		<table>
				<tr>
					<td class="formtitle" colspan="15"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保障计划详细信息</td>
				</tr>
		</table>
		<div id="planDetailDIV">
		
		</div>
		<table  id="HandleInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
				<td width="10%" align='left'><input type = "button"  name="" class="cssbutton" value="添加信息" onclick="addParams()"></td>
					<td width="10%" align='left'><input type = "button" name="" class="cssbutton" value="删除信息" onclick="deleParams()"></td>
					<td width="70%" align='right'><input type = "button"  name="savePlan" class="cssbutton" value="保障计划保存" onclick="saveContPlan()"></td>
					<td width="5%" align='right'><input type = "button" name="UpdatePlan" class="cssbutton" value="保障计划修改" onclick="updateConPlan()"></td>
					<td width="5%" align='right'><input type = "button" name="DelPlan" class="cssbutton" value="保障计划删除" onclick="deleteConPlan()"></td>
				</tr>
		</table>
		<hr>
		<table  id="HandleInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保障计划备注</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="lcContPlanReport.remark" cols="100%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td width="90%" ><input type = "button"  name="returnButton" class="cssbutton" value="返  回" onclick="javascript:history.go(-1);"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
