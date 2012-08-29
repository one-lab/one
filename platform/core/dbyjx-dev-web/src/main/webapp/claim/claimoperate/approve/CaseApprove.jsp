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
    
	    <title>案件审核</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript">
		function showPage()
		{
			tt = document.getElementById("AddAffix");
			tt.style.display="block";
		}
		</script>

	</head>
<body>
  <form name="fm" method="post" onkeypress="KeyDown()">
	<div style="width:100%">
		<table id="registerInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/RegisterInfo.jsp" /></td>
			</tr>
		</table>
		<table id="RegisterResult" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">立案结论信息</td>
			</tr>
			<tr>
				<td class="left">立案结论：</td>
					<td class="right">
						<input class="codecode" id="registerCode" name="lcReport.registerCode" class="common" type="text" value="" style="width:20%" ><input name="registerResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
					</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/CalculaInfo.jsp" /></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="FindReport" value="查看呈报" onclick="self.location.href='${ctx}/claim/claimoperate/register/ReportInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="StartSurvey" value="发起调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyApply.jsp'" />
					<input type="button" class="cssbutton" name="AccessSurvey" value="查看调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="CancelSurvey" value="取消调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyCancel.jsp'" />
					<input type="button" class="cssbutton" name="StartSecAudit" value="发起二核" onclick="self.location.href='${ctx}/claim/claimoperate/audit/SecdAuditStart.jsp'" />
					<input type="button" class="cssbutton" name="SecAuditResult" value="二核结论查看" onclick="self.location.href='${ctx}/claim/claimoperate/audit/DealSecdAudit.jsp'" />
					<input type="button" class="cssbutton" name="AffixAdjust" value="医疗单证信息查看" onClick="self.location.href='${ctx}/claim/claimoperate/approve/MedicalAffixApply.jsp'" />
					<input type="button" class="cssbutton" name="MatchClaim" value="受益人分配信息查看" onClick="self.location.href='${ctx}/claim/claimoperate/approve/BnfDistbQuery.jsp'"/>
				</td>
			</tr>
		</table>
		<hr />
		<table id="AuditMng" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">审核管理</td>
			</tr>
			<tr>
				<td >分公司审核意见</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
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
				<td class="right">
					<input class="codecode" id="auditCode" name="lcReport.auditCode" class="common" type="text" value="" style="width:20%"><input name="auditResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">案件标识：</td>
				<td class="right">
					<input class="codecode" id="caseCode" name="lcReport.caseCode" class="common" type="text" value="" style="width:20%" ><input name="caseFlag" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td  class="left">特殊备注：</td>
				<td  class="right"><input name="AuditDate" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="ApproveMng" class="common" cellpadding="3" cellspacing="1">
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
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">审批结论：</td>
				<td class="right">
					<input class="codecode" id="approveCode" name="lcReport.approveCode" class="common" type="text" value="" style="width:20%"><input name="approveResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">案件标识：</td>
				<td class="right">
					<input class="codecode" id="caseCode" name="lcReport.caseCode" class="common" type="text" value="" style="width:20%" ><input name="caseFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="SureButton" value="审批确认" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>