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
    
    <title>团体报案信息录入</title>
    
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
		<table id="GroupReportInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">团体报案信息</td>
			</tr>
			<tr>
				<td class="left">团体报案号：</td>
				<td class="right"><input name="reportNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">团体保单号：</td>
				<td class="right">
					<input class="codecode" id="groupAppCode" name="lcReport.groupAppCode" class="common" type="text" value="" style="width:20%" ><input name="groupAppNum" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">出险人查询：</td>
				<td class="right">
					<input type="button" class="cssButton" name="AppntQuery" value="出险人查询" onClick="self.location.href='${ctx}/claim/claimoperate/report/AppntQuery.jsp'" >
				</td>
			</tr>
			<tr>
				<td  class="left">报案人与出险人关系：</td>
				<td  class="right">
					<input class="codecode" id="relatshipCode" name="lcReport.relatshipCode" class="common" type="text" value="" style="width:20%" ><input name="relatship" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">报案人姓名：</td>
				<td  class="right"><input name="reportName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">报案人电话：</td>
				<td  class="right"><input name="reportTel" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">报案人通讯地址：</td>
				<td  class="right"><input name="reportAddress" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">报案方式：</td>
				<td  class="right">
					<input class="codecode" id="reportCode" name="lcReport.reportCode" class="common" type="text" value="" style="width:20%" ><input name="reportType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">报案日期：</td>
				<td class="right">
					<input name="reportDate" id="reportDate" class="common" type="text" onchange="clickable()" />
				</td>
			</tr>
			<tr>
				<td  class="left">管理机构：</td>
				<td  class="right"><input name="mngCom" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">报案受理人：</td>
				<td  class="right"><input name="reportOper" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">申请类型：</td>
				<td  class="right">
					<input class="codecode" id="applyCode" name="lcReport.applyCode" class="common" type="text" value="" style="width:20%" ><input name="applyType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">投保单位：</td>
				<td  class="right"><input name="reportAddress" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">出险人数：</td>
				<td  class="right"><input name="reportCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">估损金额：</td>
				<td  class="right"><input name="preSum" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<hr>
		<table id="AppntInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">出险人信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="14%">出险人客户号</td>
					<td width="10%">出险人姓名</td>
					<td width="10%">出险人性别</td>
					<td width="10%">出生日期</td>
					<td width="15%">证件类型</td>
					<td width="20%">证件号码</td>
					<td width="15%">员工序号</td>
				</tr>
			</thead>
			<tbody>
				<tr class=content >
					<td><input type="radio" name="Redio" value="" /></td>
					<td>1</td>
					<td>201200001</td>
					<td>马布</td>
					<td>男</td>
					<td>1986-03-01</td>
					<td>身份证</td>
					<td>123456789987435411</td>
					<td>1234567435411</td>
				</tr>
          </tbody>
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
				<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">个人出险人信息</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="PolQuery" value="保单查询" onclick="self.location.href='${ctx}/claim/claimoperate/register/PolicyQuery.jsp'" />
					<input type="button" class="cssbutton" name="PastClaimQuery" value="既往赔案查询" onclick="self.location.href='${ctx}/claim/claimoperate/register/PastClaimQuery.jsp'" />
					<input type="button" class="cssbutton" name="imageQuery" value="影像查询" onclick="" />
					<input type="button" class="cssbutton" name="AppntIn" value="出险人信息导入" onclick="" />
				</td>
			</tr>
		</table>
		<table id=AppntInfo class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">分单号：</td>
				<td class="right"><input name="subPolNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">事件号：</td>
				<td class="right"><input name="accNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人姓名：</td>
				<td class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">出险人年龄：</td>
				<td class="right"><input name="AppntAge" class="common" type="text" onchange="clickable()"></td>
				<td class="left">出险人性别：</td>
				<td class="right"><input name="AppntSex" class="common" type="text" onchange="clickable()"></td>
				<td class="left">VIP客户标记：</td>
				<td class="right"><input name="VIPFlag" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">报案号：</td>
				<td class="right"><input name="reportNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">事故日期：</td>
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
				<td class="left">出险地点：</td>
				<td class="right"><input name="caseAddress" class="common" type="text" onchange="clickable()"></td>
				<td class="left">治疗医院：</td>
				<td class="right">
					<input class="codecode" id="treatHospitalCode" name="lcReport.treatHospitalCode" class="common" type="text" value="" style="width:20%" ><input name="treatHospital" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">出险原因：</td>
				<td class="right">
					<input class="codecode" id="appntReasonCode" name="lcReport.appntReasonCode" class="common" type="text" value="" style="width:20%" ><input name="appntReason" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">意外细节：</td>
				<td class="right">
					<input class="codecode" id="unexpectDetailCode" name="lcReport.unexpectDetailCode" class="common" type="text" value="" style="width:20%" ><input name="unexpectDetail" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">治疗情况：</td>
				<td class="right">
					<input class="codecode" id="treatStateCode" name="lcReport.treatStateCode" class="common" type="text" value="" style="width:20%" ><input name="treatState" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">出险结果1：</td>
				<td class="right">	
					<input class="codecode" id="CaseResult1Code" name="lcReport.CaseResult1Code" class="common" type="text" value="" style="width:20%" ><input name="CaseResult1" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">出险结果2：</td>
				<td class="right">	
					<input class="codecode" id="CaseResult2Code" name="lcReport.CaseResult2Code" class="common" type="text" value="" style="width:20%" ><input name="CaseResult2" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">联系电话：</td>
				<td class="right">
					<input name="telephone" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">住院科室：</td>
				<td class="right"><input name="HosDepart" class="common" type="text" onchange="clickable()"></td>
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
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td><jsp:include page="../../commonpage/ClaimType.jsp" /></td>
			</tr>
			<tr>
				<td>备注</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="Remark" cols="" rows="4" style="width:98%"></textarea><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="saveButton" value="保  存" onclick="" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="startSurvey" value="发起调查" onClick="self.location.href='${ctx}/claim/claimoperate/report/SurveyApply.jsp'" />
					<input type="button" class="cssbutton" name="accessSurvey" value="查看调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="CancelSurvey" value="取消调查" onclick="self.location.href='${ctx}/claim/claimoperate/report/SurveyCancel.jsp'" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="moneyCalculation" value="预估金额试算" onclick="" /></td>
			</tr>
		</table>
		<table id="GrpPolInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">预估金额试算结果</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">序号</td>
					<td width="32%">出险人姓名</td>
					<td width="32%">赔付类型</td>
					<td width="32%">预估赔付金额</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>马布</td>
					<td>附加意外伤害医疗保险(0601)</td>
					<td>5000</td>
				</tr>
			</tbody>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "reportStart" value="发起呈报" onclick="self.location.href='${ctx}/claim/claimoperate/report/ReportApply.jsp'">
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "reportConf" value="报案确认" onclick="">
					<input type="button" class="cssbutton" name = "returnButton" value="返  回" onclick="javascript:history.back();">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
