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
    
    <title>结案信息查询</title>
    
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
		<table id="RegisterApplyInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">立案申请信息</td>
			</tr>
			<tr>
				<td  class="left">赔案号：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">出险日期：</td>
				<td  class="right">
					<input name="AppntDate" id="AppntDate" class="common" type="text" onchange="clickable()" />
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td  class="left">申请人与出险人关系：</td>
				<td  class="right">
					<input name="Relationship" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">申请人姓名：</td>
				<td  class="right">
					<input name="RgtantName" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">申请人电话：</td>
				<td  class="right">
					<input name="RgtantTel" class="common" type="text" onchange="clickable()">
				</td>
			</tr>
			<tr>
				<td  class="left">申请人地址：</td>
				<td  class="right">
					<input name="RgtantAddress" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">立案日期：</td>
				<td class="right">
					<input name="RgtDate" id="RgtDate" class="common" type="text" onchange="clickable()" />
				</td>
				<td  class="left">立案受理人：</td>
				<td  class="right"><input name="RgtAgent" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">受托人类型：</td>
				<td  class="right"><input name="AgentType" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人代码：</td>
				<td  class="right"><input name="AgentCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人姓名：</td>
				<td  class="right"><input name="AgentName" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">受托人性别：</td>
				<td  class="right"><input name="AgentType" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人电话：</td>
				<td  class="right"><input name="AgentTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人地址：</td>
				<td  class="right"><input name="AgentAddress" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">受托人邮编：</td>
				<td  class="right"><input name="AgentZip" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">团体立案号：</td>
				<td class="right">
					<input name="RgtDate" id="RgtDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="RegisterList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="30%">出险人姓名</td>
					<td width="30%">性别</td>
					<td width="30%">出生日期</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>马布</td>
					<td>男</td>
					<td>1986-03-01</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">出险人信息</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="PolQuery" value="保单查询" onclick="self.location.href='${ctx}/claim/claimoperate/register/PolicyQuery.jsp'" />
					<input type="button" class="cssbutton" name="PastClaimQuery" value="既往赔案查询" onclick="self.location.href='${ctx}/claim/claimoperate/register/PastClaimQuery.jsp'" />
					<input type="button" class="cssbutton" name="${ctx}/imageQuery" value="影像查询" onclick="" />
				</td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">出险人姓名：</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人年龄：</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人性别：</td>
				<td class="right"><input name="AppntSex" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">出险原因：</td>
				<td class="right">
					<input name="AppntReason" class="common" type="text" onchange="clickable()">
				</td>
				<td class="left">治疗医院：</td>
				<td class="right"><input name="treatHospital" class="common" type="text" onchange="clickable()"></td>
				<td class="left">联系电话：</td>
				<td class="right">
					<input name="Telephone" class="common" type="text" onchange="clickable()">
				</td>
			</tr>
			<tr>
				<td class="left">意外细节：</td>
				<td class="right"><input name="UnexpectDetail" class="common" type="text" onchange="clickable()"></td>
				<td class="left">治疗情况：</td>
				<td class="right"><input name="Treatment" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险结果1：</td>
				<td class="right">
					<input name="CaseResult1" class="common" type="text" onchange="clickable()">	
				</td>
			</tr>
			<tr>
				<td class="left">出险结果2：</td>
				<td class="right">
					<input name="CaseResult2" class="common" type="text" onchange="clickable()">
				</td>
				<td class="left">住院科室：</td>
				<td class="right"><input name="HosDepart" class="common" type="text" onchange="clickable()"></td>
				<td class="left">单证齐全标识：</td>
				<td class="right">
					<input name="EstimatAmount" class="common" type="text" onchange="clickable()">
				</td>
			</tr>
			<tr>
				<td class="left">出险地点：</td>
				<td class="right"><input name="CaseAddress" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<table id="ClaimType" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="ClaimType.jsp" /></td>
			</tr>
		</table>
		<table id="RegisterResult" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">立案结论信息</td>
			</tr>
			<tr>
				<td class="left">立案结论：</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">案件标识：</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="left">赔案状态：</td>
				<td class="right"><input name="AppntSex" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">立案人：</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">立案日期：</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="CalculaInfo.jsp" /></td>
			</tr>
		</table>
		<hr />		
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AccessReport" value="查看呈报" onclick="self.location.href='${ctx}/claim/claimoperate/register/ReportInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="AccessSurvey" value="查看调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="SecAuditResult" value="二核结论查看" onclick="self.location.href='${ctx}/claim/claimoperate/audit/DealSecdAudit.jsp'" />
					<input type="button" class="cssbutton" name="MatchClaim" value="受益人信息查看" onClick="self.location.href='${ctx}/claim/claimoperate/approve/BnfDistbQuery.jsp'"/>
					<input type="button" class="cssbutton" name="AffixAdjust" value="医疗单证查看" onClick="self.location.href='${ctx}/claim/claimoperate/approve/MedicalAffixApply.jsp'" />
				</td>
			</tr>
		</table>
		<table id="ApproveInfoMng" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">审核管理</td>
			</tr>
			<tr>
				<td class="left">审核人：</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">审核日期：</td>
				<td  class="right"><input name="AuditDate" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">审核结论：</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td class="left">案件标识：</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">特殊备注：</td>
				<td  class="right"><input name="AuditDate" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<hr />
		<table id="AuditInfoMng" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">审批管理</td>
			</tr>
			<tr>
				<td colspan="6">审批意见(包括字符最多700汉字)</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td class="left">审批人：</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">审批日期：</td>
				<td  class="right"><input name="AuditDate" class="common" type="text" onchange="clickable()"></td>
				<td class="left">审核结论：</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">案件标识：</td>
				<td class="right"><input name="Audit" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
