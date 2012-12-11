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
    
    <title>投保单复核申请</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">ctx = "${ctx}";</script>
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/proposalApprove/js/ProposalApproveApply.js"></script>
	<script type="text/javascript">
	$(function(){
		//初始化
		initialLcGrpContAudit();
	});
	</script>
  </head>
  <body>
    <form id="grpContForm" method="post">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     请输入查询集体投保单条件</td>
			</tr>
			<tr> 
				<td class="left">投保单号：</td>
				<td class="right"><input id="grpContNo" name="lcGrpCont.grpContNo" class="common" type="text" value='<s:property value="#request.lcGrpCont.grpContNo"/>'></td>
				<td class="left">销售方式：</td>
				<td class="right"><input id="grpSellType" name="lcGrpCont.grpSellType" class="codecode" value='<s:property value="#request.lcGrpCont.grpSellType"/>' type="text" ondblclick="queryCode('grpSellType','grpSellTypeName','PDLDcode1','codeType:SellingWay')"   style="width:20%"><input id="grpSellTypeName" name="grpSellTypeName" class="common" type="text" value=''  style="width:68%"></td>
				<td class="left">管理机构：</td>
				<td class="right"><input type="hidden" id="upperComCode" value='<s:property value="#session.prpDcompany.comCode"/>' /> <input class="codecode" id="manageCom" name="lcGrpCont.manageCom" value='<s:property value="#request.lcGrpCont.manageCom"/>' class="common" type="text" value='${lcReport.manageCom }' style="width: 20%"	ondblclick="queryCode('manageCom','comName','PrpDcompany','comCode:manageCom|upperComCode:upperComCode');"><input id="comName" name="comName" class="common" type="text"	style="width: 68%" value=""></td>
			</tr>
			<tr>
				<td class="left">业务员编码：</td>
				<td class="right"><input class="codecode" id="agentCode" name="lcGrpCont.agentCode" value='<s:property value="#request.lcGrpCont.agentCode"/>' class="common" type="text"  value="" style="width: 20%"  ondblclick="queryCode('agentCode','agentName','PrpDuser','codeType:agenCode')" /><input id="agentName" name="agentName" class="common" type="text" 	style="width: 68%" value=""></td>
				<td class="left">投保单位全称：</td>
				<td class="right"><input id="grpName" name="lcGrpCont.grpName" class="common" type="text" value='<s:property value="#request.lcGrpCont.grpName"/>'></td>
				<td class="left">扫描标记：</td>
				<td class="right"><input name="comCode" class="codecode" type="text"   value="" style="width:20%"><input name="comName" class="common" type="text" value=""   style="width:69%"></td>
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="findGrpContInfo()">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     共享工作池</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="31%">投保单号</td>
					<td width="31%">投保单位全称</td>
					<td width="30%">录单日期</td>
				</tr>
			</thead>
			<tbody id="PublicInfoBody">
				<s:if test="lcGrpContList!=null">
					<s:iterator value="lcGrpContList" var="lcGrpContTemp" status="s">
						<tr class="content" id='<s:property value="#lcGrpContTemp.grpContNo"/>'>
							<td width="3%"><input type="radio" name="lcGrpContRadio" value='<s:property value="#lcGrpContTemp.grpContNo"/>' /></td>
							<td width="5%"><s:property value="#s.count"/> </td>
							<td width="31%"><s:property value="#lcGrpContTemp.grpContNo"/></td>
							<td width="31%"><s:property value="#lcGrpContTemp.grpName"/></td>
							<td width="30%"><s:date name="#lcGrpContTemp.inputDate" format="YYYY-MM-DD" /></td>
						</tr>
					</s:iterator>
				</s:if>
			</tbody>
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>		
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyButton" value="申  请" onclick="applyLcGrpCont()">
				</td>
			</tr>
		</table>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     投保单信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="20%">投保单号</td>
					<td width="25%">管理机构名称</td>
					<td width="20%">录单日期</td>
					<td width="25%">投保单位全称</td>
				</tr>
			</thead>
			<tbody id="scanApplycInfoBody">
			</tbody>
		</table>
		<input type="button" value="开始复核"  onclick="auditLcGrpCont()"/>
		<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>		
	</div>
	</form>
  </body>
</html>
