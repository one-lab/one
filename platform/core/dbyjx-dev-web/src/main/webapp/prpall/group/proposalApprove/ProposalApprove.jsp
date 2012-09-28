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
    
    <title>投保单复核</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">var ctx="${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/proposalApprove/js/ProposalApprove.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/proposalPre/ProposalPreApply.js"></script>	
  </head>
  <body>
    <form id="fm" method="post" >
	<div style="width:100%">
		<br><br><br><br><br>
		影像件图片
		<hr>
		<input type="hidden" value="${lcGrpCont.grpContNo }" id="GrpContNo"/>
		<input type="hidden" id="inputLocation" value="05">
		<table id=ContImpartInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="10%">序号</td>
					<td width="20%">告知版别</td>
					<td width="20%">告知内容编号</td>
					<td width="25%">告知内容</td>
					<td width="25%">录入信息</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="lcRepInfoList!=null">
					<s:iterator value="lcRepInfoList" var="lcRepInfo" status="s">
					<tr class="content">
					<td><s:property value="#s.index"/></td>
					<td><s:property value="#lcRepInfo.id.impartVer"/></td>
					<td><s:property value="#lcRepInfo.id.impartCode"/></td>
					<td><s:property value="#lcRepInfo.impartDetailContent"/></td>
					<td><s:property value="#lcRepInfo.message"/></td>
					</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<tr class="content">
					<td colspan="4">暂无信息</td>
					</tr>
				</s:else>
			</tbody>
		</table>
	</div>
	<div style="width:100%">
		<table id="GrpPolInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">   集体保单险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">序号</td>
					<td width="15%">险种编码</td>
					<td width="15%">险种名称</td>
					<td width="15%">保费</td>
					<td width="15%">保额</td>
					<td width="15%">费用率</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="grpRiskVoList">
					<s:iterator value="grpRiskVoList" var="grpRiskVo" status="s">
					<tr class="content">
						<td><s:property value="#s.count"/></td>
						<td><s:property value="#grpRiskVo.riskCode"/></td>
						<td><s:property value="#grpRiskVo.riskName"/></td>
						<td><s:property value="#grpRiskVo.prem"/></td>
						<td><s:property value="#grpRiskVo.amnt"/></td>
						<td>0</td>
					</tr>
					</s:iterator>
					</s:if>
					<s:else>
					<tr class="content">
						<td colspan="6">暂无信息</td>
					</tr>
					</s:else>
			</tbody>
		</table>	
		
	</div>
	<div style="width:100%">
		<table id="RiskRateInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     险种费率信息（0至1之间的小数）</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">序号</td>
					<td width="12%">手续费比例</td>
					<td width="13%">个人绩效比例</td>
					<td width="13%">管理绩效比例</td>
					<td width="13%">个人费用比例</td>
					<td width="13%">团队费用比例</td>
					<td width="13%">机构费用比例</td>
					<td width="13%">前线固定费用分摊比例</td>					
				</tr>
			</thead>	
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>1</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>0.4</td>
				</tr>
			</tbody>
		</table>
		<div id="divInfo2" style="display:''">
			<table id="ButtonInfor2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name = "AddPlan" value="险种信息" onclick="location.href='../report/reportInput/EnsurePlan.jsp'">
						<input type="button" class="cssbutton" name = "AddPlan" value="保障计划定制" onclick="location.href='../report/reportInput/EnsurePlan.jsp'">
						<input type="button" class="cssbutton" name = "InsuredInfo" value="被保险人信息" onclick="location.href='../report/reportInput/InsuredListImport.jsp'">
						<input type="button" class="cssbutton" name = "InsuredInfo" value="呈报件查询" onclick="location.href='../report/reportInput/ReportAdd.jsp'">
						<input type="button" class="cssbutton" name = "BussinessNote" value="业务信息报告书" onclick="location.href='../noImageInput/StatementInput.jsp'">
						<input type="button" class="cssbutton" name = "JoinSet" value="分期付款设置" onclick="location.href='../noImageInput/InstallmentSetting.jsp'">
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<table id="ButtonInfor3" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align="right"><input type="button" class="cssbutton" name = "QueryNotepad" value="记事本查看" onclick="findNoteInfo()"></td>
				<td width="11%" align="left"><input type="button" class="cssbutton" name = "QueryIssue" value="个人已承保保单查询" onclick="findLcContAndInsured()"></td>
				<td width="11%" align="left"><input type="button" class="cssbutton" name = "QueryIssue" value="团体问题件查询" onclick="findGrpIssue()"></td>
				<td width="11%" align="left"><input type="button" class="cssbutton" name = "AddIssue" value="团体问题件录入" onclick="issueInput()"></td>
				<td width="11%" align="left"><input type="button" class="cssbutton" name = "QueryImageScan" value="影像件查询" onclick=""></td>
				<td width="6%" align="left"><input type="button" class="cssbutton" name = "AddComplete" value="复核完毕" onclick="finishAudit()"></td>
				<td width="5%" align="left"><input type="button" class="cssbutton" name = "ReturnBack" value="返  回" onclick="javascript:history.go(-1);"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
