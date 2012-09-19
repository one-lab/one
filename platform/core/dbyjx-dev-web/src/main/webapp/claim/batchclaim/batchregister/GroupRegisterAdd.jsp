<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>团体立案信息录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script language="javascript">
	function showPage(type,spanID)
	{
	  if(type.value!="01"){
	    //打开
	  	spanID.style.display="";
	  }
	  else
	  { 
	    //关闭
	    spanID.style.display="none";
	  }
	}
	</script>

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style="width:100%">
		<table id="GroupReportInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">团体报案信息</td>
			</tr>
			<tr>
				<td class="left">团体赔案号：</td>
				<td class="right"><input name="reportNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">团体保单号：</td>
				<td class="right">
					<input class="codecode" id="groupAppCode" name="lcReport.groupAppCode" class="common" type="text" value="" style="width:20%" ><input name="groupAppNum" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">出险人查询：</td>
				<td class="right">
					<input type="button" class="cssButton" name="AppntQuery" value="出险人查询" onClick="self.location.href='${ctx}/claim/claimoperate/report/AppntQuery.jsp'" /><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td  class="left">申请人与出险人关系：</td>
				<td  class="right">
					<input class="codecode" id="relaCode" name="lcReport.relaCode" class="common" type="text" value="" style="width:20%" ><input name="rela" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">申请人姓名：</td>
				<td  class="right"><input name="reportName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">申请人电话：</td>
				<td  class="right"><input name="reportTel" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">申请人地址：</td>
				<td  class="right"><input name="reportAddress" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">出险人数：</td>
				<td  class="right"><input name="reportMode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">立案日期：</td>
				<td class="right">
					<input name="reportDate" id="reportDate" class="common" type="text" onchange="clickable()" />
				</td>
			</tr>
			<tr>
				<td  class="left">受托人类型：</td>
				<td  class="right">
					<input class="codecode" id="agentCode" name="lcReport.agentCode" class="common" type="text" value="" style="width:20%" ><input name="agentType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">受托人代码：</td>
				<td  class="right"><input name="AgentCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人姓名：</td>
				<td  class="right"><input name="AgentName" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">受托人性别：</td>
				<td  class="right">
					<input class="codecode" id="agentCode" name="lcReport.agentCode" class="common" type="text" value="" style="width:20%" ><input name="agentSex" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">受托人电话：</td>
				<td  class="right"><input name="AgentTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">受托人地址：</td>
				<td  class="right"><input name="AgentAddress" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">受托人邮编：</td>
				<td  class="right"><input name="AgentZip" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">立案受理人：</td>
				<td  class="right"><input name="RgtAgent" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">管辖机构：</td>
				<td  class="right">
					<input class="codecode" id="adminComCode" name="lcReport.adminComCode" class="common" type="text" value="" style="width:20%" ><input name="adminCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">估损金额：</td>
				<td  class="right"><input name="preSum" class="common" type="text" onchange="clickable()"></td>
				<td class="common">
				<td class="common">
				<td class="common">
				<td class="common">
			</tr>
		</table>
		<hr>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">出险人列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">出险人客户号</td>
					<td width="11%">出险人姓名</td>
					<td width="10%">性别</td>
					<td width="15%">出生日期</td>
					<td width="15%">证件类型</td>
					<td width="20%">证件号码</td>
					<td width="10%">员工序号</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">出险人信息</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="PolQuery" value="保单查询" onclick="self.location.href='${ctx}/claim/claimoperate/register/PolicyQuery.jsp'" />
					<input type="button" class="cssbutton" name="PastClaimQuery" value="既往赔案查询" onclick="self.location.href='${ctx}/claim/claimoperate/register/PastClaimQuery.jsp'" />
					<input type="button" class="cssbutton" name="ImageQuery" value="影像查询" onclick="" />
					<input type="button" class="cssbutton" name="AppntIn" value="出险人信息导入" onclick="" />
				</td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">出险人姓名：</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人年龄：</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人性别</td>
				<td class="right">
					<input class="codecode" id="appntCode" name="lcReport.appntCode" class="common" type="text" value="01" style="width:20%" ><input name="appntSex" class="common" type="text" onchange="clickable()" style="width:68%" value="男">
				</td>
			</tr>
			<tr>
				<td class="left">报案分案号：</td>
				<td class="right"><input name="subreportNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">事故日期：</td>
				<td class="right">
					<input name="accDate" id="accDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'accDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td  class="left">出险日期：</td>
				<td class="right">
					<input name="AppntDate" id="AppntDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'AppntDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">出险原因：</td>
				<td class="right">
					<input class="codecode" id="appntReasonCode" name="lcReport.appntReasonCode" class="common" type="text" value="" style="width:20%" ><input name="appntReason" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">治疗医院：</td>
				<td class="right">
					<input class="codecode" id="treatHospitalCode" name="lcReport.treatHospitalCode" class="common" type="text" value="" style="width:20%" ><input name="treatHospital" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">治疗情况：</td>
				<td class="right">
					<input class="codecode" id="treatStateCode" name="lcReport.treatStateCode" class="common" type="text" value="" style="width:20%" ><input name="treatState" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">意外细节：</td>
				<td class="right">
					<input class="codecode" id="unexpectDetailCode" name="lcReport.unexpectDetailCode" class="common" type="text" value="" style="width:20%" ><input name="unexpectDetail" class="common" type="text" onchange="clickable()" style="width:68%" value="">
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
				<td class="left">联系电话：</td>
				<td class="right">
					<input name="Telephone" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">出险地点：</td>
				<td class="right"><input name="AppntAddress" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">案件标识：</td>
				<td class="right">
					<input class="codecode" id="caseCode" name="lcReport.caseCode" class="common" type="text" value="" style="width:20%" ><input name="caseFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">死亡日期：</td>
				<td class="right">
					<input name="DeathDate" id="DeathDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'DeathDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="common">
				<td class="common">
			</tr>
		</table>
		<table id="claimType" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../../commonpage/ClaimType.jsp" /></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="saveButton" value="保  存" onclick="" />
					<input type="button" class="cssbutton" name="delButton" value="删  除" onclick="" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="ProCertify" value="生成单证" onclick="self.location.href='${ctx}/claim/claimoperate/register/ClaimAffixImptNew.jsp'" />
					<input type="button" class="cssbutton" name="CertifyDest" value="单证回销" onclick="self.location.href='${ctx}/claim/claimoperate/register/ClaimAffixImpt.jsp'">
					<input type="button" class="cssbutton" name="PrintCertify" value="打印单证通知书清单" onclick="" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="StartSurvey" value="发起调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyApply.jsp'" />
					<input type="button" class="cssbutton" name="CancelSurvey" value="取消调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyCancel.jsp'" />
					<input type="button" class="cssbutton" name="AccessSurvey" value="查看调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="AccessReport" value="查看呈报" onclick="self.location.href='${ctx}/claim/claimoperate/register/ReportInfoQuery.jsp'" />
				</td>
			</tr>
		</table>
		<table id="RegisterInfo" class="common" cellpadding="3" cellspacing="1">
				<tr>
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">立案结论信息</td>
				</tr>
				<tr>
					<td class="left">立案结论：</td>
					<td class="right">
						<input class="codecode" id="registerCode" name="lcReport.registerCode" class="common" type="text" value="" style="width:20%" ><input name="registerResult" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
					</td>
					<td>
						<input type="button" class="cssbutton" name = "ResultSave" value="结论保存" onclick="">
					</td>
				</tr>
		</table>
		<hr />
		<table id="refuseRegister" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">不予立案原因：</td>
				<td class="right">
					<input class="codecode" id="refuseRegistCode" name="lcReport.refuseRegistCode" class="common" type="text" value="06" style="width:20%" ><input name="refuseRegist" class="common" type="text" onchange="clickable()" style="width:68%" value="索赔单证不齐全">
				</td>
				<td>
					<input type="button" class="cssbutton" name = "printRefuRegist" value="打印不予立案通知书" onclick="">
				</td>
			</tr>
		</table>
		<hr />
		<table id="delayRegist" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>延迟立案原因(包括符号最多300符号)</td>
			</tr>
			<tr>
				<td>
					<textarea name="delayRegist" cols="" rows="4" style="width:100%"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "printDelayRegist" value="打印延迟立案通知书" onclick="">
				</td>
			</tr>
	    </table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="RegisterConf" value="立案确认" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
