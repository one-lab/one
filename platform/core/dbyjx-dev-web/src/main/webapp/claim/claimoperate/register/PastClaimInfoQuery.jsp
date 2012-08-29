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
    
    <title>既往赔案详细信息查询</title>
    
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
		<table id="RegisterInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">立案信息</td>
			</tr>
			<tr>
				<td  class="left">事件号：</td>
				<td  class="right"><input name="EventNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">赔案号：</td>
				<td  class="right"><input name="ClaimNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">申请人姓名：</td>
				<td  class="right"><input name="ApplyName" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">申请人电话：</td>
				<td  class="right"><input name="ApplyTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">申请人地址：</td>
				<td  class="right"><input name="ApplyAddr" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">申请人与出险人关系：</td>
				<td  class="right">
					<input class="codecode" id="relatshipCode" name="lcReport.relatshipCode" class="common" type="text" value="" style="width:20%" ><input name="relatship" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">出险地点：</td>
				<td  class="right"><input name="AppPlace" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">立案日期：</td>
				<td  class="right"><input name="RgtDate" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">管辖机构：</td>
				<td  class="right"><input name="JurisCom" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">立案受理人：</td>
				<td  class="right"><input name="Rgtant" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人类型：</td>
				<td  class="right"><input name="AgentMode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人代码：</td>
				<td  class="right"><input name="AgentCode" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">受托人姓名：</td>
				<td  class="right"><input name="AgentName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人性别：</td>
				<td  class="right"><input name="AgentSex" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人电话：</td>
				<td  class="right"><input name="AgentTel" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">受托人地址：</td>
				<td  class="right"><input name="AgentAddr" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人邮编：</td>
				<td  class="right"><input name="AgentZip" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">申请类型：</td>
				<td  class="right"><input name="ApplyType" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">理赔金领取方式：</td>
				<td  class="right"><input name="ClaimGetType" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/AppntInfoList.jsp" /></td>
			</tr>
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
		<table id="RegisterInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">出险人姓名：</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人年龄：</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人性别：</td>
				<td class="right"><input name="AppntSex" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">联系电话：</td>
				<td class="right">
					<input name="Telephone" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">事故日期：</td>
				<td class="right">
					<input name="AccidDate" id="AccidDate" class="common" type="text" onchange="clickable()" value='' /><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">出险原因：</td>
				<td class="right">
					<input class="codecode" id="appntReasonCode" name="lcReport.appntReasonCode" class="common" type="text" value="" style="width:20%" ><input name="appntReason" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">治疗医院：</td>
				<td class="right">
					<input class="codecode" id="treatHospitalCode" name="lcReport.treatHospitalCode" class="common" type="text" value="" style="width:20%" ><input name="treatHospital" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">出险日期：</td>
				<td class="right">
					<input name="AppntDate" id="AppntDate" class="common" type="text" onchange="clickable()" value='' /><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">意外细节：</td>
				<td class="right">
					<input class="codecode" id="unexpectDetailCode" name="lcReport.unexpectDetailCode" class="common" type="text" value="" style="width:20%" ><input name="unexpectDetail" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			<tr>
				<td class="left">治疗情况：</td>
				<td class="right">
					<input class="codecode" id="treatStateCode" name="lcReport.treatStateCode" class="common" type="text" value="" style="width:20%" ><input name="treatState" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">出险结果1：</td>
				<td class="right">	
					<input class="codecode" id="CaseResult1Code" name="lcReport.CaseResult1Code" class="common" type="text" value="" style="width:20%" ><input name="CaseResult1" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">出险结果2：</td>
				<td class="right">	
					<input class="codecode" id="CaseResult2Code" name="lcReport.CaseResult2Code" class="common" type="text" value="" style="width:20%" ><input name="CaseResult2" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">住院科室：</td>
				<td class="right"><input name="HosDepart" class="common" type="text" onchange="clickable()"></td>
		        <td class="left">单证齐全标识：</td>
				<td class="right">
					<input class="codecode" id="affixComplCode" name="lcReport.affixComplCodee" class="common" type="text" value="" style="width:20%" ><input name="affixComplFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td class="left">案件标识：</td>
				<td class="right"><input name="CaseFlag" class="common" type="text" onchange="clickable()"></td>
				<td class="left">赔付次数：</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="ClaimType" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/ClaimType.jsp" /></td>
			</tr>
			<tr>
				<td >备注</td>
			</tr>
			<tr>
				<td><textarea name="Remark" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="RegisterResult" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">立案结论信息</td>
			</tr>
			<tr>
				<td class="left">立案结论</td>
				<td class="right">
					<input class="codecode" id="registerCode" name="lcReport.registerCode" class="common" type="text" value="" style="width:20%"><input name="registerResult" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
		</table>
		<hr />
	</div>
	<div style="width:100%">
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/CalculaInfo.jsp" /></td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AccessReport" value="查看呈报" onclick="self.location.href='${ctx}/claim/claimoperate/register/ReportInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="AccessSurvey" value="查看调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="RemarkInfo" value="备注信息" onclick="" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="MedCtfInfoQuery" value="医疗单证信息查看" onClick="self.location.href='${ctx}/claim/claimoperate/approve/MedicalAffixApply.jsp'" />
					<input type="button" class="cssbutton" name="ApproveQuery" value="二核结论查看" onclick="self.location.href='${ctx}/claim/claimoperate/audit/DealSecdAudit.jsp'" />
					<input type="button" class="cssbutton" name="BnfDtbQuery" value="受益人分配信息查看" onClick="self.location.href='${ctx}/claim/claimoperate/approve/BnfDistbQuery.jsp'" />
					<input type="button" class="cssbutton" name="ApproveQuery" value="审核审批结论查看" onclick="" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/ApproveAuditMng.jsp" /></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input  type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
 				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
